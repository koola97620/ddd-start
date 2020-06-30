package me.jdragon.chapter3;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author choijaeyong on 2020/06/16.
 * @project my-ddd
 * @description
 */

@Embeddable
public class MemberId implements Serializable {
  @Column(name="member_id")
  private String id;

  public String getId() {
    return id;
  }
}
