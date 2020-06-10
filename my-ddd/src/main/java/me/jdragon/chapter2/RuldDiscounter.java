package me.jdragon.chapter2;

import java.util.List;

/**
 * @author choijaeyong on 2020/06/10.
 * @project my-ddd
 * @description
 */
public interface RuldDiscounter {
  public Money applyRules(Customer customer, List<OrderLine> orderLines);

}
