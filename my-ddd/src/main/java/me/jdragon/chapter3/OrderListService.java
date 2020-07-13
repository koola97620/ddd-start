package me.jdragon.chapter3;

import java.util.List;
import me.jdragon.chapter3.dto.OrderView;

/**
 * @author choijaeyong on 2020/07/13.
 * @project my-ddd
 * @description
 */
public class OrderListService {

  private OrderViewDao orderViewDao;

  public OrderListService(OrderViewDao orderViewDao) {

    this.orderViewDao = orderViewDao;
  }

  public List<OrderView> getOrderList(String ordererId) {
    return orderViewDao.selectByOrderer(ordererId);
  }

}
