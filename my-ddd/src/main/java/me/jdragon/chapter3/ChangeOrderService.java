package me.jdragon.chapter3;

import me.jdragon.chapter2.OrderNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
public class ChangeOrderService {
  private OrderRepository orderRepository;
  private CustomerRepository customerRepository;

  public ChangeOrderService(OrderRepository orderRepository , CustomerRepository customerRepository) {
    this.orderRepository = orderRepository;
    this.customerRepository = customerRepository;
  }

  @Transactional
  public void changeShippingInfo(OrderId orderId, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
    Order order = orderRepository.findById(orderId);
    if (order == null) throw new OrderNotFoundException();

    order.changeShippingInfo(newShippingInfo);

    if (useNewShippingAddrAsMemberAddr) {
      Customer customer = customerRepository.findById(order.getOrderer().getCustomerId());
      customer.changeAddress(newShippingInfo.getAddress());
    }
  }
}
