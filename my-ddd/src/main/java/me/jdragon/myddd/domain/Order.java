package me.jdragon.myddd.domain;

import java.util.List;

/**
 * @author choijaeyong on 19/04/2019.
 * @project my-ddd
 * @description
 */
public class Order {
  private OrderState state;
  private ShippingInfo shippingInfo;
  private List<OrderLine> orderLines;
  private Money totalAmounts;

  public Order(List<OrderLine> orderLines) {
    setOrderLines(orderLines);
  }
  public void setOrderLines(List<OrderLine> orderLines) {
    verifyAtLeastOneOrMoreOrderLines(orderLines);
    this.orderLines = orderLines;
    calculateTotalAmounts();
  }

  private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
    if(orderLines == null || orderLines.isEmpty()) {
      throw new IllegalArgumentException("no OrderLine");
    }
  }

  private void calculateTotalAmounts() {
    this.totalAmounts = new Money(orderLines.stream()
        .mapToInt(x -> x.getAmounts().getValue()).sum());
  }

//  public void changeShippingInfo(ShippingInfo newShippingInfo) {
//    if(!isShippingChangeable()) {
//      throw new IllegalStateException("can't change shipping in " + state);
//    }
//    this.shippingInfo = newShippingInfo;
//  }

  public boolean isShippingChangeable() {
    return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
  }


}
