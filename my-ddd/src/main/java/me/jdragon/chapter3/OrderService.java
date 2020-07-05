package me.jdragon.chapter3;

import me.jdragon.chapter1.OrderNo;

/**
 * @author choijaeyong on 2020/07/05.
 * @project my-ddd
 * @description
 */
public class OrderService {

  private OrderRepository orderRepository;

  public OrderService(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public OrderNo placeOrder(OrderRequest orderRequest) {
    OrderNo orderNo = orderRepository.nextId();
    Order order = createOrder(orderNo, orderRequest);
    orderRepository.save(order);
    return orderNo;

  }

  private Order createOrder(OrderNo orderNo, OrderRequest orderRequest) {
    return null;
  }

}
