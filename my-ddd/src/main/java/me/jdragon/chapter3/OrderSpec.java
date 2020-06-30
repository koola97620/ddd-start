package me.jdragon.chapter3;



/**
 * @author choijaeyong on 2020/07/01.
 * @project my-ddd
 * @description
 */
public class OrderSpec implements Specification<Order> {

  private String ordererId;

  public OrderSpec(String ordererId) {
    this.ordererId = ordererId;
  }

  @Override
  public boolean isSatisfiedBy(Order agg) {
    return agg.getOrderer().getMemberId().getId().equals(ordererId);
  }
}
