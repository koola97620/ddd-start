package me.jdragon.chapter3;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import me.jdragon.chapter3.dto.OrderView;
import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/06/13.
 * @project my-ddd
 * @description
 */
@Repository
public class JpaOrderViewDao implements OrderViewDao {
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<OrderView> selectByOrderer(String ordererId) {
    String selectQuery =
        "select dto.OrderView(o,m,p) "
            + "from Order o join o.orderLines ol, Member m, Product p "
            + "where o.orderer.memberId.id = :ordererId "
            + "and o.orderer.memberId.id = m.id "
            + "and index(ol) = 0 "
            + "and ol.productId = p.id "
            + "order by o.number.number desc";

    TypedQuery<me.jdragon.chapter3.dto.OrderView> query = entityManager
        .createQuery(selectQuery, me.jdragon.chapter3.dto.OrderView.class);
    query.setParameter("ordererId" , ordererId);
    return query.getResultList();
  }
}
