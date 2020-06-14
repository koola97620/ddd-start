package me.jdragon.chapter3;

import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */

@Entity
@Table(name = "product")
public class Product {
  @EmbeddedId
  private ProductId id;

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;

  private CategoryId category;
}
