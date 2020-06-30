package me.jdragon.chapter3;

/**
 * @author choijaeyong on 2020/07/01.
 * @project my-ddd
 * @description
 */
public interface Specification<T> {
  public boolean isSatisfiedBy(T agg);

}
