package me.jdragon.chapter3;

import java.util.Date;
import java.util.List;
import me.jdragon.chapter1.OrderNo;
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

  List<Order> findByOrderer(String ordererId, Date fromDate, Date toDate);

  OrderNo nextId();
}
