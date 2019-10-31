package com.devonfw.bookshop.customerservice.customermanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.repo.CustomerRepository;
import com.devonfw.bookshop.customerservice.general.logic.base.AbstractUc;

/**
 * Abstract use case for Customers, which provides access to the commonly necessary data access objects.
 */
public class AbstractCustomerUc extends AbstractUc {

  /** @see #getCustomerRepository() */
  @Inject
  private CustomerRepository customerRepository;

  /**
   * Returns the field 'customerRepository'.
   * 
   * @return the {@link CustomerRepository} instance.
   */
  public CustomerRepository getCustomerRepository() {

    return this.customerRepository;
  }

}
