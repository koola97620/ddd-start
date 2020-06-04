package me.jdragon.chapter1;


import java.util.List;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class Order {
  private OrderState state;
  private ShippingInfo shippingInfo;
  private List<OrderLine> orderLines;
  private Money totalAmounts;

  public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
    setOrderLines(orderLines);
    setShippingInfo(shippingInfo);
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


  public void changeShippingInfo(ShippingInfo shippingInfo) {
    if (!isShippingChangeable()) {
      throw new IllegalArgumentException("can't change shipping in " + state);
    }
    this.shippingInfo = shippingInfo;
  }

  private boolean isShippingChangeable() {
    return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
  }

  public void changeShipped() {
    this.state = OrderState.SHIPPED;
  }

  public void cancel() {

  }

  public void completePayment() {

  }
}
