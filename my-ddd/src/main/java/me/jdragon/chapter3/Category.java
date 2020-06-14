package me.jdragon.chapter3;

import java.util.List;
import java.util.Set;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
public class Category {
  private Set<Product> products;

  public List<Product> getProducts(int page, int size) {
    List<Product> sortedProducts = sortById(products);
    return sortedProducts.subList( (page - 1) * size, page * size);
  }

  private List<Product> sortById(Set<Product> products) {
    return null;
  }

  public Long getId() {
    return null;
  }
}
