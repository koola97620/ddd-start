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
  private String receiverName;
  private String receiverPhoneNumber;
  private String shippingAddress1;
  private String shippingAddress2;
  private String shippingZipcode;


}
