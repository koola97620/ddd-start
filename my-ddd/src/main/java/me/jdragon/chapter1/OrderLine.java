package me.jdragon.chapter1;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class OrderLine {

  private final Product product;
  private final int price;
  private final int quantity;
  private final Money amounts;

  public OrderLine(Product product,int price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private Money calculateAmounts() {
    return new Money(price * quantity);
  }

  public Money getAmounts() {
    return amounts;
  }

}
