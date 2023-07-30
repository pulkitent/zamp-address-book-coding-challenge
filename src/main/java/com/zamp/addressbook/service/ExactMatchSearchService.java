package com.zamp.addressbook.service;

import com.zamp.addressbook.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExactMatchSearchService implements ISearchService {
  private final Map<String, List<Contact>> nameContactMap;
  private final Map<String, Contact> phoneContactMap;

  public ExactMatchSearchService() {
    this.phoneContactMap = new HashMap<>();
    this.nameContactMap = new HashMap<>();
  }

  @Override
  public void insert(Contact contact) {
    String name = contact.getFirstName().toLowerCase();
    List<Contact> contacts = nameContactMap.getOrDefault(name, new ArrayList<>());
    contacts.add(contact);
    nameContactMap.put(name, contacts);
    phoneContactMap.put(contact.getPhoneNumber(), contact);
  }

  @Override
  public List<Contact> searchByName(String name) {
    return this.nameContactMap.get(name);
  }

  @Override
  public List<Contact> searchByPhone(String phone) {
    return Collections.singletonList(phoneContactMap.get(phone));
  }
}
