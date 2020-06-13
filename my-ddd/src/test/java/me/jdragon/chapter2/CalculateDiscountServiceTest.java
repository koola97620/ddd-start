package me.jdragon.chapter2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

/**
 * @author choijaeyong on 2020/06/11.
 * @project my-ddd
 * @description
 */
public class CalculateDiscountServiceTest {

  private List<OrderLine> orderLines;

  @Test
  public void test() {
    RuleDiscounter droolsRuleDiscounter = new DroolsRuleDiscounter();
    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(null,droolsRuleDiscounter);

    SimpleRuleDiscounter simpleRuleDiscounter = new SimpleRuleDiscounter();
    CalculateDiscountService calculateDiscountService2 = new CalculateDiscountService(null,simpleRuleDiscounter);
  }

  @BeforeEach
  public void setUp() {
    orderLines = new ArrayList<>();
  }

  @Test
  @Description("정상동작")
  public void test2() {
    CustomerRepository stubRepo = mock(CustomerRepository.class);
    when(stubRepo.findById("noCustId")).thenReturn(null);
    RuleDiscounter stubRule = (cust, lines) -> null;

    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(stubRepo,
        stubRule);

    assertThatExceptionOfType(NoCustomerException.class)
        .isThrownBy( () -> calculateDiscountService.calculateDiscount(orderLines, "noCustId"));
  }

  @Test
  @Description("목으로 대체할 객체를 의존성 주입으로 받지 않을때")
  public void not_using_DI() {
    CustomerRepository stubRepo = mock(CustomerRepository.class);
    when(stubRepo.findById("noCustId")).thenReturn(null);
    RuleDiscounter stubRule = (cust, lines) -> null;

    CalculateDiscountService cs = new CalculateDiscountService(stubRule);
    //cs.calculateDiscount(orderLines, "noCustId"); // 이건 에러가 안나요. mock 객체가 대역을 못해.
    assertThatExceptionOfType(NoCustomerException.class)
        .isThrownBy( () -> cs.calculateDiscount(orderLines, "noCustId"));

//    CalculateDiscountService calculateDiscountService = new CalculateDiscountService(stubRepo,
//        stubRule);
//
//    assertThatExceptionOfType(NoCustomerException.class)
//        .isThrownBy( () -> calculateDiscountService.calculateDiscount(orderLines, "noCustId"));
  }

  @Test
  @DisplayName("생성자 주입을 통해 구현변경의 어려움을 해결")
  public void constructor() {
    RuleDiscounter ruleDiscounter = new DroolsRuleDiscounter();
    CalculateDiscountService discountService = new CalculateDiscountService(ruleDiscounter);

    RuleDiscounter ruleDiscounter2 = new SimpleRuleDiscounter();
    CalculateDiscountService discountService2 = new CalculateDiscountService(ruleDiscounter2);
  }

}
