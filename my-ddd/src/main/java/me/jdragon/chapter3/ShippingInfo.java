package me.jdragon.chapter3;

import me.jdragon.chapter1.Address;
import me.jdragon.chapter1.Receiver;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class ShippingInfo {

  // 개념적으로 받는 사람을 의미한다
//  private String receiverName;
//  private String receiverPhoneNumber;
  private Receiver receiver;

  // 개념적으로 주소를 나타낸다.
//  private String shippingAddress1;
//  private String shippingAddress2;
//  private String shippingZipcode;
  private Address address;

  public Address getAddress() {
    return this.address;
  }
}
