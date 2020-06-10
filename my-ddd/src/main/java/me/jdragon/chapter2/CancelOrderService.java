package me.jdragon.chapter2;

/**
 * @author choijaeyong on 2020/06/10.
 * @project my-ddd
 * @description
 */
public class CancelOrderService {

  public void cancelOrder(String orderId) {
    Order order = findOrderById(orderId);
    if (order == null) throw new OrderNotFoundException(orderId);
    order.cancel();
  }

  private Order findOrderById(String orderId) {
    return null;
  }

}
