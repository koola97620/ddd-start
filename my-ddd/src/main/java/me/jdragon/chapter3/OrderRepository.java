package me.jdragon.chapter3;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
@Repository
public interface OrderRepository {

  Order findById(OrderId orderId);
  void save(Order order);
  void delete(Order order);
  //List<Order> findByOrdererId(String ordererId, int startRow, int size);
}
