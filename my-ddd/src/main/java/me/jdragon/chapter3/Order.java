package me.jdragon.chapter3;


import java.util.List;
import me.jdragon.chapter1.OrderNo;

import me.jdragon.myddd.domain.OrderState;


/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class Order {
  private OrderNo id;
  private OrderState state;
  private ShippingInfo shippingInfo;
  private String orderNumber;
  private Orderer orderer;

  private Money totalAmounts;
  //private List<OrderLine> orderLines;
  private OrderLines orderLines;
  public void changeOrderLines(List<OrderLine> newLines) {
    orderLines.changeOrderLines(newLines);
    this.totalAmounts = orderLines.getTotalAmounts();
  }
//  private void calculateTotalAmounts() {
//    this.totalAmounts = new me.jdragon.chapter1.Money(
//        orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum()
//    );
//  }

  public Order(Orderer orderer,List<OrderLine> orderLines, ShippingInfo shippingInfo, OrderState state) {
    setOrderer(orderer);
    setOrderLines(orderLines);
    setShippingInfo(shippingInfo);
  }

  private void setOrderer(Orderer orderer) {
    if (orderer == null) throw new IllegalArgumentException("no orderer");
    this.orderer = orderer;
  }

  private void setShippingInfo(ShippingInfo shippingInfo) {
    if (shippingInfo == null)
      throw new IllegalArgumentException("no shippinginfo");

    this.shippingInfo = shippingInfo;
  }

  private void setOrderLines(List<OrderLine> orderLines) {
    verifyAtLeastOneOrMoreOrderLines(orderLines);
    //this.orderLines = orderLines;
    //calculateTotalAmounts();
  }

  private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
    if (orderLines == null || orderLines.isEmpty()) {
      throw new IllegalArgumentException("no OrderLine");
    }
  }
  public void changeShippingInfo(ShippingInfo shippingInfo) {
    verifyNotYetShipped();
    setShippingInfo(shippingInfo);
//    if (!isShippingChangeable()) {
//      throw new IllegalArgumentException("can't change shipping in " + state);
//    }
//    this.shippingInfo = shippingInfo;
  }

  private void verifyNotYetShipped() {
    if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
      throw new IllegalArgumentException("already shipped");
  }
//  private boolean isShippingChangeable() {
//    return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
//  }

  public void changeShipped() {
    this.state = OrderState.SHIPPED;
  }

  public void cancel() {
    verifyNotYetShipped();
    this.state = OrderState.CANCELED;
  }

  public void completePayment() {

  }

  public OrderNo getId() {
    return id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ( (orderNumber == null) ? 0 : orderNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (obj.getClass() != Order.class) return false;
    Order other = (Order)obj;
    if (this.orderNumber == null) return false;
    return this.orderNumber.equals(other.orderNumber);
  }

  public Orderer getOrderer() {
    return this.orderer;
  }
}
