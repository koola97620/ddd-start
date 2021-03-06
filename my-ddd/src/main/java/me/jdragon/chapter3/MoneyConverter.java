package me.jdragon.chapter3;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author choijaeyong on 2020/06/17.
 * @project my-ddd
 * @description
 */
@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money,Integer> {

  @Override
  public Integer convertToDatabaseColumn(Money money) {
    if (money == null)
      return null;
    else
      return money.getValue();
  }

  @Override
  public Money convertToEntityAttribute(Integer value) {
    if (value  == null)
      return null;
    else
      return new Money(value);
  }
}
