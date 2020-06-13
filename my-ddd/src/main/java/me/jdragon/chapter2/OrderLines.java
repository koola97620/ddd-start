package me.jdragon.chapter2;

import java.util.List;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
public class OrderLines {
  private List<OrderLine> lines;
  public Money getTotalAmounts() {
    int sum = lines.stream().mapToInt(x -> x.getAmounts().getValue()).sum();
    return new Money(sum);
  }
  
  public void changeOrderLines(List<OrderLine> newLines) {
    this.lines = newLines;
  }
}
