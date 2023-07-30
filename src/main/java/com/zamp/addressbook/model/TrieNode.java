package com.zamp.addressbook.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
  private final Map<Character, TrieNode> children;
  private final List<Contact> contacts;

  public TrieNode() {
    children = new HashMap<>();
    contacts = new ArrayList<>();
  }

  public Map<Character, TrieNode> getChildren() {
    return children;
  }

  public List<Contact> getContacts() {
    return contacts;
  }
}
