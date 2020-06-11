package me.jdragon.chapter2;

import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/06/11.
 * @project my-ddd
 * @description
 */
public class CalculateDiscountServiceTest {

  @Test
  public void test() {
    RuleDiscounter droolsRuleDiscounter = new DroolsRuleDiscounter();
    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(droolsRuleDiscounter);

    SimpleRuleDiscounter simpleRuleDiscounter = new SimpleRuleDiscounter();
    CalculateDiscountService calculateDiscountService2 = new CalculateDiscountService(simpleRuleDiscounter);





  }

}
