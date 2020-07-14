package me.jdragon.chapter3;

import java.util.List;
import me.jdragon.chapter1.OrderNo;
import me.jdragon.chapter3.dto.OrderView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author choijaeyong on 2020/07/06.
 * @project my-ddd
 * @description
 */
@Controller
public class OrderController {

  private OrderService orderService;
  private OrderViewDao orderViewDao;

  public OrderController(OrderService orderService, OrderViewDao orderViewDao) {

    this.orderService = orderService;
    this.orderViewDao = orderViewDao;
  }

  @RequestMapping("/myorders")
  public String list(ModelMap model) {
    String ordererId = "";
    List<OrderView> orderViews = orderViewDao.selectByOrderer(ordererId);
    model.addAttribute("orders",orderViews);
    return "order/list";
  }

  @RequestMapping(value = "/order/place", method = RequestMethod.POST)
  public String order(OrderRequest orderRequest, ModelMap modelMap) {
    setOrderer(orderRequest);
    OrderNo orderNo = orderService.placeOrder(orderRequest);
    modelMap.addAttribute("orderNo", orderNo.toString());
    return "order/success";
  }

  private void setOrderer(OrderRequest orderRequest) {


  }

}
