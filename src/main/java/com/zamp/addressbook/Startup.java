package com.zamp.addressbook;

import com.zamp.addressbook.model.Address;
import com.zamp.addressbook.model.AddressBook;
import com.zamp.addressbook.model.Contact;
import com.zamp.addressbook.service.ISearchService;
import com.zamp.addressbook.service.TypeAheadSearchService;

import java.util.List;

public class Startup {
  public static void main(String[] args) {
    ISearchService typeAheadSearchService = new TypeAheadSearchService();
    AddressBook addressBook = new AddressBook(typeAheadSearchService);

    Address address = new Address("", "", "", "", "", "");
    addressBook.addContact(new Contact("Pulkit", "Gupta", "9711253132", address));
    addressBook.addContact(new Contact("Nimish", "Gupta", "9711253333", address));
    addressBook.addContact(new Contact("Sudhanshu", "Gupta", "9711254444", address));
    addressBook.addContact(new Contact("Siddharth", "Gupta", "9711255555", address));
    addressBook.addContact(new Contact("Abhishek", "Gupta", "9711256666", address));

    List<Contact> contacts = addressBook.searchByPhone("971125");
    contacts.isEmpty();
  }
}
