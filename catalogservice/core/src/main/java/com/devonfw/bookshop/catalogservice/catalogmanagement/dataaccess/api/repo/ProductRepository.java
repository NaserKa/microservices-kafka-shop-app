package com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api.ProductEntity;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link ProductEntity}
 */
public interface ProductRepository extends DefaultRepository<ProductEntity> {

  /**
   * @param criteria the {@link ProductSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link ProductEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<ProductEntity> findByCriteria(ProductSearchCriteriaTo criteria) {

    ProductEntity alias = newDslAlias();
    JPAQuery<ProductEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    String description = criteria.getDescription();
    if (description != null && !description.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
    }
    BigDecimal price = criteria.getPrice();
    if (price != null) {
      query.where($(alias.getPrice()).eq(price));
    }
    Integer quantity = criteria.getQuantity();
    if (quantity != null) {
      query.where($(alias.getQuantity()).eq(quantity));
    }
    Instant lastChange = criteria.getLastChange();
    if (lastChange != null) {
      query.where($(alias.getLastChange()).eq(lastChange));
    }
    Integer lastProductNumber = criteria.getLastProductNumber();
    if (lastProductNumber != null) {
      query.where($(alias.getLastProductNumber()).eq(lastProductNumber));
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
  public default void addOrderBy(JPAQuery<ProductEntity> query, ProductEntity alias, Sort sort) {

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
          case "description":
            if (next.isAscending()) {
              query.orderBy($(alias.getDescription()).asc());
            } else {
              query.orderBy($(alias.getDescription()).desc());
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
          case "lastChange":
            if (next.isAscending()) {
              query.orderBy($(alias.getLastChange()).asc());
            } else {
              query.orderBy($(alias.getLastChange()).desc());
            }
            break;
          case "lastProductNumber":
            if (next.isAscending()) {
              query.orderBy($(alias.getLastProductNumber()).asc());
            } else {
              query.orderBy($(alias.getLastProductNumber()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}