package me.jdragon.chapter3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
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

  @Convert(converter = MoneyConverter.class)
  private Money money;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},orphanRemoval = true)
  @JoinColumn(name = "product_id")
  @OrderColumn(name ="list_idx")
  private List<Image> images = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;

  private CategoryId category;

  public void changeImages(List<Image> newImages) {
    images.clear();
    images.addAll(newImages);
  }
}
