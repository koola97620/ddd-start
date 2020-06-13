package me.jdragon.chapter3;



/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
public interface CustomerRepository {

  Customer findById(String customerId);
}
