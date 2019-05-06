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

  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(this == obj) return true;
    if(!(obj instanceof Receiver)) return false;
    Receiver that = (Receiver)obj;
    return this.name.equals(that.name) && this.phoneNumber.equals(that.phoneNumber);
  }
}
