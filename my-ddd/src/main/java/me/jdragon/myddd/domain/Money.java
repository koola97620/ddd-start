package me.jdragon.myddd.domain;

/**
 * @author choijaeyong on 20/04/2019.
 * @project my-ddd
 * @description
 */
public class Money {
  private int value;

  public Money(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Money add(Money money) {
    return new Money(this.value + money.value);
  }

  public Money multiply(int multiplier) {
    return new Money(value * multiplier);
  }

}
