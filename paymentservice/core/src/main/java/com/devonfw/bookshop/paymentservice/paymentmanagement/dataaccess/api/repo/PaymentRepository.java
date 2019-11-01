package com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.time.Instant;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.PaymentEntity;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * {@link DefaultRepository} for {@link PaymentEntity}
 */
public interface PaymentRepository extends DefaultRepository<PaymentEntity> {

  /**
   * @param criteria the {@link PaymentSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link PaymentEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<PaymentEntity> findByCriteria(PaymentSearchCriteriaTo criteria) {

    PaymentEntity alias = newDslAlias();
    JPAQuery<PaymentEntity> query = newDslQuery(alias);

    Long orderId = criteria.getOrderId();
    if (orderId != null) {
      query.where($(alias.getOrderId()).eq(orderId));
    }
    Boolean paid = criteria.getPaid();
    if (paid != null) {
      query.where($(alias.getPaid()).eq(paid));
    }
    Instant paymentDate = criteria.getPaymentDate();
    if (paymentDate != null) {
      query.where($(alias.getPaymentDate()).eq(paymentDate));
    }
    if (criteria.getPageable() == null) {
      criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
    } else {
      addOrderBy(query, alias, criteria.getPageable().getSort());
    }

    return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
  }

  @Query("select payment from PaymentEntity payment where payment.orderId = ?1")
  PaymentEntity findPaymentByOrderId(long orderId);

  /**
   * Add sorting to the given query on the given alias
   * 
   * @param query to add sorting to
   * @param alias to retrieve columns from for sorting
   * @param sort specification of sorting
   */
  public default void addOrderBy(JPAQuery<PaymentEntity> query, PaymentEntity alias, Sort sort) {

    if (sort != null && sort.isSorted()) {
      Iterator<Order> it = sort.iterator();
      while (it.hasNext()) {
        Order next = it.next();
        switch (next.getProperty()) {
          case "orderId":
            if (next.isAscending()) {
              query.orderBy($(alias.getOrderId()).asc());
            } else {
              query.orderBy($(alias.getOrderId()).desc());
            }
            break;
          case "paid":
            if (next.isAscending()) {
              query.orderBy($(alias.getPaid()).asc());
            } else {
              query.orderBy($(alias.getPaid()).desc());
            }
            break;
          case "paymentDate":
            if (next.isAscending()) {
              query.orderBy($(alias.getPaymentDate()).asc());
            } else {
              query.orderBy($(alias.getPaymentDate()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
