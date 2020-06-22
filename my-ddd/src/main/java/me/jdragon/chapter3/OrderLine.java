package me.jdragon.chapter3;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import me.jdragon.chapter1.Product;

/**
 * @author choijaeyong on 2020/06/03.
 * @project my-ddd
 * @description
 */
@Embeddable
public class OrderLine {

  @Embedded
  private ProductId productId;

  private final Product product;

  @Column(name = "price")
  private final Money price;

  @Column(name = "quantity")
  private final int quantity;

  @Column(name="amounts")
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
