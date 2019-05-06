package me.jdragon.myddd.domain;

import java.util.List;

/**
 * @author choijaeyong on 19/04/2019.
 * @project my-ddd
 * @description
 */
public class Order {
  // OrderNo 타입 자체로 id 가 주문번호임을 알 수 있다.
  private OrderNo id;
  private OrderState state;
  private ShippingInfo shippingInfo;
  private List<OrderLine> orderLines;
  private Money totalAmounts;
  private Orderer orderer;

  public Order(Orderer orderer,List<OrderLine> orderLines , ShippingInfo shippingInfo) {
    setOrderer(orderer);
    setOrderLines(orderLines);
    setShippingInfo(shippingInfo);
  }

  private void setOrderer(Orderer orderer) {
    if(orderer == null) throw new IllegalArgumentException("no orderer");
    this.orderer = orderer;
  }

  private void setOrderLines(List<OrderLine> orderLines) {
    verifyAtLeastOneOrMoreOrderLines(orderLines);
    this.orderLines = orderLines;
    calculateTotalAmounts();
  }

  public OrderNo getId() {
    return id;
  }

  public void setShippingInfo(ShippingInfo shippingInfo) {
    if(shippingInfo == null) {
      throw new IllegalArgumentException("no ShippingInfo");
    }
    this.shippingInfo = shippingInfo;
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

//  public boolean isShippingChangeable() {
//    return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
//  }

  public void changeShippingInfo(ShippingInfo newShippingInfo) {
    verifyNotYetShipped();
    setShippingInfo(newShippingInfo);
  }

  public void cancel() {
    verifyNotYetShipped();
    this.state = OrderState.CANCELED;
  }

  public void verifyNotYetShipped() {
    if(state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
      throw new IllegalArgumentException("already shipped");
    }
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null) return false;
    if(obj.getClass() != Order.class) return false;
    Order other = (Order)obj;
    if(this.id == null) return false;
    return this.id.equals(other.id);
  }
}
