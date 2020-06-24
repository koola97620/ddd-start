package me.jdragon.chapter1;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author choijaeyong on 2020/06/10.
 * @project my-ddd
 * @description
 */

@Embeddable
public class OrderNo implements Serializable {
  @Column(name="order_number")
  private String number;

  public boolean is2ndGeneration() {
    return number.startsWith("N");
  }

}
