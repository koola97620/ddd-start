package me.jdragon.chapter3;

import java.util.List;
import me.jdragon.chapter3.dto.OrderView;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
public interface OrderViewDao {
  List<OrderView> selectByOrderer(String ordererId);

}
