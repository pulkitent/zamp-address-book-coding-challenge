package com.zamp.addressbook.model;

import com.zamp.addressbook.service.ISearchService;

import java.util.List;

public class AddressBook {
  private final ISearchService searchService;

  public AddressBook(ISearchService searchService) {
    this.searchService = searchService;
  }

  public void addContact(Contact contact) {
    this.searchService.insert(contact);
  }

  public List<Contact> searchByName(String name) {
    return this.searchService.searchByName(name);
  }

  public List<Contact> searchByPhone(String phone) {
    return this.searchService.searchByPhone(phone);
  }
}
