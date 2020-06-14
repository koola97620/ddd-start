package me.jdragon.chapter3;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author choijaeyong on 2020/06/14.
 * @project my-ddd
 * @description
 */
@Embeddable
public class ProductId {
  @Column(name = "id")
  private int id;

}
