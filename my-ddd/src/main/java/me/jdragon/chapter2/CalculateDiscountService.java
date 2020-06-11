package me.jdragon.chapter2;

import java.util.List;

/**
 * @author choijaeyong on 2020/06/11.
 * @project my-ddd
 * @description
 */
public class CalculateDiscountService {

  private RuleDiscounter ruleDiscounter;

  public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
    this.ruleDiscounter = ruleDiscounter;
  }

  public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
    return null;
  }


}
