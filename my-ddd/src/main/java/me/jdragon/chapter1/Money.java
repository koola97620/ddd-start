package me.jdragon.chapter1;

import lombok.val;

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

  public int getValue() {
    return value;
  }
}
