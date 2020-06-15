package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/06/15.
 * @project my-ddd
 * @description
 */
public class JpaOrderRepository implements OrderRepository {

  @Override
  public Order findById(OrderId orderId) {
    return null;
  }

  @Override
  public void save(Order order) {

  }
}
