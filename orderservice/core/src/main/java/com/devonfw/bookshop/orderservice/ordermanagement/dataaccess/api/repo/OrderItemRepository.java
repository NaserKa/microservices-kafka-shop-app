package com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderItemEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link OrderItemEntity}
 */
public interface OrderItemRepository extends DefaultRepository<OrderItemEntity> {

  /**
   * @param criteria the {@link OrderItemSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link OrderItemEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<OrderItemEntity> findByCriteria(OrderItemSearchCriteriaTo criteria) {

    OrderItemEntity alias = newDslAlias();
    JPAQuery<OrderItemEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    BigDecimal price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
    }
    Integer quantity = criteria.getQuantity();
    if (quantity != null) {
      query.where($(alias.getQuantity()).eq(quantity));
    }
    Long productId = criteria.getProductId();
    if (productId != null) {
      query.where($(alias.getProductId()).eq(productId));
    }
    Long order = criteria.getOrderId();
    if (order != null) {
      query.where($(alias.getOrder().getId()).eq(order));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<OrderItemEntity> query, OrderItemEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "name":
            if (next.isAscending()) {
              query.orderBy($(alias.getName()).asc());
            } else {
              query.orderBy($(alias.getName()).desc());
            }
            break;
          case "price":
            if (next.isAscending()) {
              query.orderBy($(alias.getPrice()).asc());
            } else {
              query.orderBy($(alias.getPrice()).desc());
            }
            break;
          case "quantity":
            if (next.isAscending()) {
              query.orderBy($(alias.getQuantity()).asc());
            } else {
              query.orderBy($(alias.getQuantity()).desc());
            }
            break;
          case "productId":
            if (next.isAscending()) {
              query.orderBy($(alias.getProductId()).asc());
            } else {
              query.orderBy($(alias.getProductId()).desc());
            }
            break;
          case "order":
            if (next.isAscending()) {
              query.orderBy($(alias.getOrder().getId()).asc());
            } else {
              query.orderBy($(alias.getOrder().getId()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}