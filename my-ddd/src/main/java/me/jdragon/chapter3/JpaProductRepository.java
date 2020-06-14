package me.jdragon.chapter3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/06/14.
 * @project my-ddd
 * @description
 */
@Repository
public class JpaProductRepository implements ProductRepository{

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<Product> findByCategoryId(CategoryId categoryId, int page, int size) {
    TypedQuery<Product> query = em.createQuery(
        "select p from Product p where :catId member of p.categoryIds order by p.id.id desc",
        Product.class);

    query.setParameter("catId", categoryId);
    query.setFirstResult( (page - 1) * size);
    query.setMaxResults(size);
    return query.getResultList();
  }

  @Override
  public int countsByCategoryId(Long id) {
    return 0;
  }
}
