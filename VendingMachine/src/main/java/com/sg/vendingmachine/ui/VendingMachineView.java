/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.VendingMachine;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LA-San
 */
public class VendingMachineView {
    
    private UserIO io;
    
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List All Items");
        io.print("2. Insert Coins (example: 2.5)");
        io.print("3. Select Item");
        io.print("4. Return Change");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public void displayVendingMachineList(List<VendingMachine> vendingMachineList) {
        for (VendingMachine currentItem : vendingMachineList) {
            io.print(currentItem.getItemID() + " | "
                    + currentItem.getItemName() + " | $"
                    + currentItem.getItemCost());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }
    
    public double displayInsertCoinPrompt(){
        return io.readDouble("Please insert coins to continue. ");
    }
    
    public void displayInsertCoinBanner(Double money){
        io.print("You inserted " + money);
        io.readString("Please hit enter to continue.");
    }
    
    public String displayUserSelectionPrompt(){
        return io.readString("Please enter the Item ID to make a selection. ");
    }
    
    public void displayItemRemoved(VendingMachine selectedItem){
        io.print("1 " + selectedItem.getItemName() + " removed.");
    }
    
    public void displayChangeDue(BigDecimal quarter, BigDecimal dime, BigDecimal nickel, BigDecimal penny){
        io.print("You're change due back is: " + quarter + " quarters, " + dime + " dimes, " + nickel + " nickels, " + penny + " pennies.");
    }
    
    public void displayNoSelectionMade(){
        io.print("You haven't made a selection. ");
    }
    
    public void displayNoCoinsEntered(){
        io.print("You haven't entered any coins. ");
    }
    
    public void displayItemNotAvailable(VendingMachine selectedItem){
        io.print(selectedItem.getItemName() + " is not currently available.");
    }
}
