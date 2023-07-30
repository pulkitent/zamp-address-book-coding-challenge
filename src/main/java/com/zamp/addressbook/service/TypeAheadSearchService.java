package com.zamp.addressbook.service;

import com.zamp.addressbook.model.Contact;
import com.zamp.addressbook.model.Trie;

import java.util.ArrayList;
import java.util.List;

public class TypeAheadSearchService implements ISearchService {
  private final Trie nameContactTrie;
  private final Trie phoneContactTrie;

  public TypeAheadSearchService() {
    this.phoneContactTrie = new Trie();
    this.nameContactTrie = new Trie();
  }

  @Override
  public void insert(Contact contact) {
    nameContactTrie.insert(contact.getFirstName(), contact);
    phoneContactTrie.insert(contact.getPhoneNumber(), contact);
  }

  @Override
  public List<Contact> searchByPhone(String phone) {
    List<Contact> results = new ArrayList<>();
    List<String> prefixes = generatePrefixes(phone);

    for (String prefix : prefixes) {
      results.addAll(phoneContactTrie.getAllSuggestions(prefix));
    }
    return results;
  }

  @Override
  public List<Contact> searchByName(String name) {
    List<Contact> results = new ArrayList<>();
    List<String> prefixes = generatePrefixes(name);

    for (String prefix : prefixes) {
      results.addAll(nameContactTrie.getAllSuggestions(prefix));
    }
    return results;
  }

  private List<String> generatePrefixes(String query) {
    List<String> prefixes = new ArrayList<>();

    for (int index = 1; index <= query.length(); index++) {
      prefixes.add(query.substring(0, index).toLowerCase());
    }
    return prefixes;
  }
}
