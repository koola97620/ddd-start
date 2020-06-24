package me.jdragon.chapter3;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author choijaeyong on 2020/06/24.
 * @project my-ddd
 * @description
 */

@Entity
public class Article {
  @Id
  private Long id;

}
