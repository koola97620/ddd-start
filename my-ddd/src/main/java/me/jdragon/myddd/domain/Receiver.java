package me.jdragon.myddd.domain;

/**
 * @author choijaeyong on 05/04/2019.
 * @project my-ddd
 * @description
 */
public class Receiver {
  private String name;
  private String phoneNumber;

  public Receiver(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return this.name;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

}
