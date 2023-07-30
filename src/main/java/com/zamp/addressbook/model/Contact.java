package com.zamp.addressbook.model;

public class Contact {
  private final String firstName;
  private final String lastName;
  private final String phoneNumber;
  private final Address address;

  public Contact(String firstName, String lastName, String phoneNumber, Address address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }
}
