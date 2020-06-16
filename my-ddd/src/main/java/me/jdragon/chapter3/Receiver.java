package me.jdragon.chapter3;

import javax.persistence.Column;

/**
 * @author choijaeyong on 2020/06/07.
 * @project my-ddd
 * @description
 */
public class Receiver {

  @Column(name = "receiver_name")
  private String name;
  @Column(name = "receiver_phone")
  private String phoneNumber;

  public Receiver(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  protected Receiver(){}

  public String getName() {
    return name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(Object other) {
    if (other == null) return false;
    if (this == other) return true;
    if ( ! (other instanceof Receiver)) return false;
    Receiver that = (Receiver) other;
    return this.name.equals(that.name) &&
        this.phoneNumber.equals(that.phoneNumber);
  }
}
