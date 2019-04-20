package me.jdragon.myddd.domain;

/**
 * @author choijaeyong on 19/04/2019.
 * @project my-ddd
 * @description
 */
public class OrderLine {
  private Product product;
  private Money price;
  private int quantity;
  private Money amounts;

  public OrderLine(Product product, Money price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private Money calculateAmounts() {
    return price.multiply(quantity);
  }

//  public int calculateAmounts() {
//    return price * quantity;
//  }

//  public int getAmounts() {
//    return amounts;
//  }
  public Money getAmounts() {
    return amounts;
  }


}
