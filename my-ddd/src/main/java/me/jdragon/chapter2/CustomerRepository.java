package me.jdragon.chapter2;

/**
 * @author choijaeyong on 2020/06/11.
 * @project my-ddd
 * @description
 */
public class CustomerRepository {

  public Customer findById(String customerId) {
    return new Customer(customerId);
  }
}
