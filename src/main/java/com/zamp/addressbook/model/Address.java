package com.zamp.addressbook.model;

public class Address {
  private final String houseNumber;
  private final String society;
  private final String city;
  private final String state;
  private final String country;
  private final String pincode;

  public Address(String houseNumber, String society, String city, String state, String country, String pincode) {
    this.houseNumber = houseNumber;
    this.society = society;
    this.city = city;
    this.state = state;
    this.country = country;
    this.pincode = pincode;
  }
}
