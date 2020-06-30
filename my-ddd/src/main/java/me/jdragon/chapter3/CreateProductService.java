package me.jdragon.chapter3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author choijaeyong on 2020/06/30.
 * @project my-ddd
 * @description
 */
public class CreateProductService {
  @Autowired
  private ProductIdService idService;
  @Autowired
  private ProductRepository productRepository;

  @Transactional
  public ProductId createProduct(ProductCreationCommand cmd) {
    ProductId productId = idService.nextId();
    Product product = new Product(productId);
    productRepository.save(product);
    return productId;
  }

}
