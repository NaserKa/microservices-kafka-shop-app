package com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerCto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;

public interface UcFindCustomer {

  /**
   * Returns a Customer by its id 'id'.
   *
   * @param id The id 'id' of the Customer.
   * @return The {@link CustomerEto} with id 'id'
   */
  CustomerEto findCustomer(long id);

  /**
   * Returns a paginated list of Customers matching the search criteria.
   *
   * @param criteria the {@link CustomerSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CustomerEto}s.
   */
  Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria);

  /**
   * Returns a composite Customer by its id 'id'.
   *
   * @param id The id 'id' of the Customer.
   * @return The {@link CustomerCto} with id 'id'
   */
  CustomerCto findCustomerCto(long id);

  /**
   * Returns a paginated list of composite Customers matching the search criteria.
   *
   * @param criteria the {@link CustomerSearchCriteriaTo}.
   * @return the {@link List} of matching {@link CustomerCto}s.
   */
  Page<CustomerCto> findCustomerCtos(CustomerSearchCriteriaTo criteria);

  /**
   * Returns a List of all Customers.
   *
   * @param
   * @return the {@link List} of all {@link CustomerCto}s.
   */
  List<CustomerCto> findAllCustomers();

}
