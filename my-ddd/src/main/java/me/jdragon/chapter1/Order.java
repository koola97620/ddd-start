package me.jdragon.chapter1;


import java.util.List;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class Order {
  private OrderNo id;
  private OrderState state;
  private ShippingInfo shippingInfo;
  private List<OrderLine> orderLines;
  private Money totalAmounts;
  private String orderNumber;
  private Orderer orderer;

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
    this.orderLines = orderLines;
    calculateTotalAmounts();
  }

  private void calculateTotalAmounts() {
    this.totalAmounts = new Money(
        orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum()
    );
  }

  private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
    if (orderLines == null || orderLines.isEmpty()) {
      throw new IllegalArgumentException("no OrderLine");
    }
  }

  private void verifyNotYetShipped() {
    if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
      throw new IllegalArgumentException("already shipped");
  }
//  private boolean isShippingChangeable() {
//    return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
//  }


  public void changeShippingInfo(ShippingInfo shippingInfo) {
    verifyNotYetShipped();
    setShippingInfo(shippingInfo);
//    if (!isShippingChangeable()) {
//      throw new IllegalArgumentException("can't change shipping in " + state);
//    }
//    this.shippingInfo = shippingInfo;
  }

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
}
