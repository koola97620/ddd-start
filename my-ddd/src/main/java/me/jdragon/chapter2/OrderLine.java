package me.jdragon.chapter2;

import me.jdragon.chapter1.Product;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
public class OrderLine {

  private final Product product;
  private final Money price;
  private final int quantity;
  private final Money amounts;

  public OrderLine(Product product, Money price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private Money calculateAmounts() {
    return new Money(price.getValue() * quantity);
  }

  public Money getAmounts() {
    return amounts;
  }

}
