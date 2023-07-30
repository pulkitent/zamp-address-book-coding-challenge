package com.zamp.addressbook.model;

import java.util.ArrayList;
import java.util.List;

public class Trie {
  private final TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String key, Contact contact) {
    String word = key.toLowerCase();
    TrieNode current = root;

    for (Character character : word.toCharArray()) {
      if (!current.getChildren().containsKey(character)) {
        current.getChildren().put(character, new TrieNode());
      }
    }
    current.getContacts().add(contact);
  }

  public List<Contact> getAllSuggestions(String prefix) {
    List<Contact> results = new ArrayList<>();
    TrieNode current = root;

    for (char ch : prefix.toCharArray()) {
      current = current.getChildren().get(ch);
      if (current == null) {
        return results;
      }
    }
    collectContacts(current, results);
    return results;
  }

  private void collectContacts(TrieNode node, List<Contact> results) {
    results.addAll(node.getContacts());
    for (TrieNode child : node.getChildren().values()) {
      collectContacts(child, results);
    }
  }
}
