package me.jdragon.chapter3;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author choijaeyong on 2020/06/10.
 * @project my-ddd
 * @description
 */

@Embeddable
public class Orderer {

  @Embedded
  @AttributeOverrides(
      @AttributeOverride(name="id", column = @Column(name = "orderer_id"))
  )
  private MemberId memberId;

  @Column(name = "orderer_name")
  private String name;

  private String customerId;
  public String getCustomerId() {
    return customerId;
  }

  public MemberId getMemberId() {
    return memberId;
  }
}
