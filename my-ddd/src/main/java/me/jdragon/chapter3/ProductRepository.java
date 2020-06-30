package me.jdragon.chapter3;

import java.util.List;

/**
 * @author choijaeyong on 2020/06/14.
 * @project my-ddd
 * @description
 */
public interface ProductRepository {

  List<Product> findByCategoryId(CategoryId categoryId, int page, int size);

  int countsByCategoryId(Long id);

  void save(Product product);

}
