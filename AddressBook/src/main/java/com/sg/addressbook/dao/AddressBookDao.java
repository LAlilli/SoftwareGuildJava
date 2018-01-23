/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.Address;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LA-San
 */
public interface AddressBookDao {
   Address addAddress(String lastName, Address addresses) throws AddressBookDaoException;

   List<Address> getAllAddresses() throws AddressBookDaoException;

   Address getAddress(String lastName) throws AddressBookDaoException;

   Address removeAddress(String lastName) throws AddressBookDaoException;
   
   int getNumberOfAddresses(Map<String, Address> address) throws AddressBookDaoException;
}
