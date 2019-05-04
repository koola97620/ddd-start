package me.jdragon.myddd.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author choijaeyong on 19/04/2019.
 * @project my-ddd
 * @description
 */

@Getter
@Setter
public class ShippingInfo {
//  private String receiverName;
//  private String receiverPhoneNumber;
//  private String shippingAddress1;
//  private String shippingAddress2;
//  private String shippingZipcode;

  private Receiver receiver;
  private Address address;

  public ShippingInfo(Receiver receiver, Address address) {
    this.receiver = receiver;
    this.address = address;
  }

  public Receiver getReceiver() {
    return receiver;
  }

  public Address getAddress() {
    return address;
  }
}
