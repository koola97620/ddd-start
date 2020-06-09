package me.jdragon.chapter1;

/**
 * @author choijaeyong on 2020/06/07.
 * @project my-ddd
 * @description
 */
public class Receiver {

  private final String name;
  private final String phoneNumber;

  public Receiver(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

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
