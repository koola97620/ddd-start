package me.jdragon.chapter3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */

@Embeddable
public class ShippingInfo {

  // 개념적으로 받는 사람을 의미한다
//  private String receiverName;
//  private String receiverPhoneNumber;
  @Embedded
  private Receiver receiver;

  // 개념적으로 주소를 나타낸다.
//  private String shippingAddress1;
//  private String shippingAddress2;
//  private String shippingZipcode;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name="zipCode" , column = @Column(name="shipping_zipcode")),
      @AttributeOverride(name="address1" , column = @Column(name="shipping_addr1")),
      @AttributeOverride(name="address2" , column = @Column(name="shipping_addr2"))
  })
  private Address address;

  @Column(name="shipping_mssage")
  private String message;

  public Address getAddress() {
    return this.address;
  }
}
