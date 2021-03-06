package me.jdragon.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},orphanRemoval = true , fetch = FetchType.EAGER)
  @JoinColumn(name = "product_id")
  @OrderColumn(name ="list_idx")
  private List<ImageAbstract> imageAbstracts = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
  private Set<CategoryId> categoryIds;

  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "product_option", joinColumns = @JoinColumn(name = "product_id"))
  @OrderColumn(name = "list_idx")
  private List<Option> options = new ArrayList<>();

  private CategoryId category;

  public Product(ProductId productId) {

  }

  public void changeImages(List<ImageAbstract> newImageAbstracts) {
    imageAbstracts.clear();
    imageAbstracts.addAll(newImageAbstracts);
  }
}
