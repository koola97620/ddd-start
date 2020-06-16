package me.jdragon.chapter3;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author choijaeyong on 2020/06/15.
 * @project my-ddd
 * @description
 */
public class JpaOrderRepository implements OrderRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Order findById(OrderId orderId) {
    return em.find(Order.class,orderId);
  }

  @Override
  public void save(Order order) {
    em.persist(order);
  }

  @Override
  public void delete(Order order) {
    em.remove(order);
  }
}
