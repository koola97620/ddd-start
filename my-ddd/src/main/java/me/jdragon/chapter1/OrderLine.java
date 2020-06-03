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
  private final int amounts;

  public OrderLine(Product product,int price, int quantity) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.amounts = calculateAmounts();
  }

  private int calculateAmounts() {
    return price * quantity;
  }

  public int getAmounts() {
    return 0;
  }

}
