package me.jdragon.chapter2;

/**
 * @author choijaeyong on 2020/06/10.
 * @project my-ddd
 * @description
 */
public class OrderNotFoundException extends RuntimeException {

  public OrderNotFoundException(String orderId) {
    super(orderId);
  }

  public OrderNotFoundException() {

  }
}
