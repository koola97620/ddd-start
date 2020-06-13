package me.jdragon.chapter2;

import java.util.List;

/**
 * @author choijaeyong on 2020/06/11.
 * @project my-ddd
 * @description
 */
public class CalculateDiscountService {

  private CustomerRepository customerRepository;
  private RuleDiscounter ruleDiscounter;

  public CalculateDiscountService(RuleDiscounter ruleDiscounter) {
    customerRepository = new CustomerRepository();
    this.ruleDiscounter = ruleDiscounter;
  }

  public Money calculateDiscount(List<OrderLine> orderLines, String customerId) {
    Customer customer = findCustomer(customerId);
    return ruleDiscounter.applyRules(customer, orderLines);
  }

  private Customer findCustomer(String customerId) {
    Customer customer = customerRepository.findById(customerId);
    if (customer == null)
      throw new NoCustomerException();
    return customer;
  }

  public CalculateDiscountService(CustomerRepository customerRepository,  RuleDiscounter ruleDiscounter) {
    this.customerRepository = customerRepository;
    this.ruleDiscounter = ruleDiscounter;
  }


  private DroolsRuleDiscounter droolsRuleDiscounter;
  public CalculateDiscountService() {
    droolsRuleDiscounter = new DroolsRuleDiscounter();
  }
  public Money calculateDiscountUsingDroolsDiscounter(List<OrderLine> orderLines,
      String customerId) {
    Customer customer = findCustomer(customerId);
    Money money = droolsRuleDiscounter.calc();
    return money;
  }
}
