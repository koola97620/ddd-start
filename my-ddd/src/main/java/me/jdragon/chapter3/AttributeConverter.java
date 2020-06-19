package me.jdragon.chapter3;

import javax.persistence.Converter;

/**
 * @author choijaeyong on 2020/06/19.
 * @project my-ddd
 * @description
 */

@Converter(autoApply = true)
public class AttributeConverter implements javax.persistence.AttributeConverter<Money,Integer> {

  @Override
  public Integer convertToDatabaseColumn(Money money) {
    return null;
  }

  @Override
  public Money convertToEntityAttribute(Integer integer) {
    return null;
  }
}
