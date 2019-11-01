package com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.repo;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Query;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link OrderEntity}
 */
public interface OrderRepository extends DefaultRepository<OrderEntity> {

  /**
   * @param criteria the {@link OrderSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link OrderEntity} objects that matched the search. If no pageable is set, it will
   *         return a unique page with all the objects that matched the search.
   */
  default Page<OrderEntity> findByCriteria(OrderSearchCriteriaTo criteria) {

    OrderEntity alias = newDslAlias();
    JPAQuery<OrderEntity> query = newDslQuery(alias);

    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  @Query("SELECT order FROM OrderEntity order")
  List<OrderEntity> findAllOrder();

  /**
   * Add sorting to the given query on the given alias
   *
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<OrderEntity> query, OrderEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }
}
