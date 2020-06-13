package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/06/04.
 * @project my-ddd
 * @description
 */
public class Money {
  private int value;

  public Money(int value) {
    this.value = value;
  }

  public Money() {

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
