package me.jdragon.chapter3;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 * @author choijaeyong on 2020/06/14.
 * @project my-ddd
 * @description
 */
public class ProductListService {

  private CategoryRepository categoryRepository;
  private ProductRepository productRepository;

  public ProductListService(CategoryRepository categoryRepository, ProductRepository productRepository) {
    this.categoryRepository = categoryRepository;
    this.productRepository = productRepository;
  }

//  public Page<Product> getProductOfCategory(Long categoryId, int page, int size) {
//    Category category = categoryRepository.findById(categoryId);
//    checkCategory(category);
//    List<Product> productList = productRepository.findByCategoryId(category.getId() , page,size);
//    int totalCount = productRepository.countsByCategoryId(category.getId());
//    return new Page(page,size,totalCount,productList);
//  }

  private void checkCategory(Category category) {

  }

}
