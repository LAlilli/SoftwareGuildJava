/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.InsufficientFundsException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.VendingMachine;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class VendingMachineController {
    VendingMachineView view;
    private VendingMachineServiceLayer service;
    
    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }
    
    public void run () {
        boolean keepGoing = true;
        int menuSelection = 0;
        String userSelection = null;
        
        //try catch block for persistence exception
        try {
            //list items on app load
            listAllItems();
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listAllItems();
                        break;
                    case 2: 
                        insertCoin();
                        break;
                    case 3:
                        //try catch block for selecting item
                        try {
                            userSelection = selectItem();
                        } catch (InsufficientFundsException e){
                            view.displayErrorMessage(e.getMessage());
                        } catch (NoItemInventoryException e){
                            view.displayErrorMessage(e.getMessage());
                        } catch (NullPointerException e){
                            view.displayErrorMessage(e.getMessage());
                        }
                        break;
                    case 4:
                        returnChange(userSelection);
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        } 
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listAllItems() throws VendingMachinePersistenceException {
        List<VendingMachine> vendingMachineList = service.getAllItems();

        view.displayVendingMachineList(vendingMachineList);
    }
    
    private void insertCoin() throws VendingMachinePersistenceException{
        //prompt user to enter coins
        double userChange = view.displayInsertCoinPrompt();
        service.insertCoin(userChange);
        
        //show user what was entered to confirm
        view.displayInsertCoinBanner(userChange);
    }
    
    private String selectItem() throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException, NullPointerException {
        VendingMachine selectedItem;
        double userChange = service.getMachineBalance();
        
        if(userChange > 0.0){
            //show user the coins they put in
            view.displayInsertCoinBanner(userChange);
            
            //prompt user for selection and set to inventory object
            String userSelection = view.displayUserSelectionPrompt();
            if(userSelection.length() != 2){
                view.displayUnknownCommandBanner();
            } 
            selectedItem = service.selectItem(userSelection);
            
            //compare user selection and amount of coins entered
            if(userSelection.equals(selectedItem.getItemID()) && selectedItem.getNumberOfItem() > 0){
                if(userChange >= selectedItem.getItemCost()){
                    view.displayItemRemoved(selectedItem);
                    selectedItem = service.removeItem(selectedItem.getNumberOfItem(), selectedItem.getItemName(), selectedItem.getItemID());
                    return userSelection;
                } else {
                    view.displayErrorMessage("You don't have enough money! You entered: " + userChange);
                }
            } else if(selectedItem.getNumberOfItem() == 0){
                //if 0 of item in inventeroy
                view.displayErrorMessage("There are no more " + selectedItem.getItemName() + " left.");
                view.displayItemNotAvailable(selectedItem);
            } else if(!userSelection.equals(selectedItem.getItemID())){
                // if user enters an ID that does not exist
                view.displayUnknownCommandBanner();
            } else if(userSelection.isEmpty()){
                //if user has not made a selection
                view.displayNoSelectionMade();
            } 
        } else {
            //user has not entered any coins
            view.displayNoCoinsEntered();
        }
        return null;
    }
    
    private void returnChange(String userSelection) throws VendingMachinePersistenceException{
        Change bgChange = new Change();
        VendingMachine selectedItem = service.getItem(userSelection);
        double userChange = service.getMachineBalance();
        
        //determine if user entered coins
        if(userChange > 0.0){
            //determine if user made a selection
            if(selectedItem != null){
                   //determine change due back to user, if any
                   bgChange.getChange(userChange, selectedItem.getItemCost());
                   view.displayChangeDue(bgChange.getQuarter(), bgChange.getDime(), bgChange.getNickel(), bgChange.getPenny());     
            } else if(selectedItem == null){
                //user did not make a selection, but would like change back
                view.displayChangeDue(bgChange.getQuarter(), bgChange.getDime(), bgChange.getNickel(), bgChange.getPenny());
            } else {
                //user did not make a selection AND did not enter any coins
                view.displayNoSelectionMade();
                view.displayNoCoinsEntered();
            }
        }
    }  

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}