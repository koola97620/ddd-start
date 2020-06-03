package me.jdragon.chapter1;


/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class Order {
  private OrderState state;
  private ShippingInfo shippingInfo;

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
}
