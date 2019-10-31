package com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.time.Instant;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.CustomerEntity;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link CustomerEntity}
 */
public interface CustomerRepository extends DefaultRepository<CustomerEntity> {

  /**
   * @param criteria the {@link CustomerSearchCriteriaTo} with the criteria to search.
   * @return the {@link Page} of the {@link CustomerEntity} objects that matched the search. If no pageable is set, it
   *         will return a unique page with all the objects that matched the search.
   */
  default Page<CustomerEntity> findByCriteria(CustomerSearchCriteriaTo criteria) {

    CustomerEntity alias = newDslAlias();
    JPAQuery<CustomerEntity> query = newDslQuery(alias);

    String name = criteria.getName();
    if (name != null && !name.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
    }
    String lastname = criteria.getLastname();
    if (lastname != null && !lastname.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getLastname()), lastname, criteria.getLastnameOption());
    }
    String adress = criteria.getAdress();
    if (adress != null && !adress.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getAdress()), adress, criteria.getAdressOption());
    }
    String city = criteria.getCity();
    if (city != null && !city.isEmpty()) {
      QueryUtil.get().whereString(query, $(alias.getCity()), city, criteria.getCityOption());
    }
    Instant lastChange = criteria.getLastChange();
    if (lastChange != null) {
      query.where($(alias.getLastChange()).eq(lastChange));
    }
    Integer customerNumber = criteria.getCustomerNumber();
    if (customerNumber != null) {
      query.where($(alias.getCustomerNumber()).eq(customerNumber));
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
  public default void addOrderBy(JPAQuery<CustomerEntity> query, CustomerEntity alias, Sort sort) {

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
          case "lastname":
            if (next.isAscending()) {
              query.orderBy($(alias.getLastname()).asc());
            } else {
              query.orderBy($(alias.getLastname()).desc());
            }
            break;
          case "adress":
            if (next.isAscending()) {
              query.orderBy($(alias.getAdress()).asc());
            } else {
              query.orderBy($(alias.getAdress()).desc());
            }
            break;
          case "city":
            if (next.isAscending()) {
              query.orderBy($(alias.getCity()).asc());
            } else {
              query.orderBy($(alias.getCity()).desc());
            }
            break;
          case "lastChange":
            if (next.isAscending()) {
              query.orderBy($(alias.getLastChange()).asc());
            } else {
              query.orderBy($(alias.getLastChange()).desc());
            }
            break;
          case "customerNumber":
            if (next.isAscending()) {
              query.orderBy($(alias.getCustomerNumber()).asc());
            } else {
              query.orderBy($(alias.getCustomerNumber()).desc());
            }
            break;
          default:
            throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
        }
      }
    }
  }

}
