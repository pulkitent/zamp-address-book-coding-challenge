package com.zamp.addressbook.service;

import com.zamp.addressbook.model.Contact;

import java.util.List;

public interface ISearchService {
  List<Contact> searchByName(String name);

  List<Contact> searchByPhone(String phone);

  void insert(Contact contact);
}
