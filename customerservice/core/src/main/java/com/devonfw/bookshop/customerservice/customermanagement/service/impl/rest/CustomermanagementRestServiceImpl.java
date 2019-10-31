package com.devonfw.bookshop.customerservice.customermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.customerservice.customermanagement.logic.api.Customermanagement;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerCto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.bookshop.customerservice.customermanagement.service.api.rest.CustomermanagementRestService;

import java.util.List;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Customermanagement}.
 */
@Named("CustomermanagementRestService")
public class CustomermanagementRestServiceImpl implements CustomermanagementRestService {

  @Inject
  private Customermanagement customermanagement;

  @Override
  public CustomerEto getCustomer(long id) {

    return this.customermanagement.findCustomer(id);
  }

  @Override
  public CustomerEto saveCustomer(CustomerEto customer) {

    return this.customermanagement.saveCustomer(customer);
  }

  @Override
  public CustomerEto updateCustomer(long id, CustomerEto customer) {
    return this.customermanagement.updateCustomer(id, customer);
  }

  @Override
  public void deleteCustomer(long id) {

    this.customermanagement.deleteCustomer(id);
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo searchCriteriaTo) {

    return this.customermanagement.findCustomers(searchCriteriaTo);
  }

  @Override
  public List<CustomerCto> findAllCustomers() {
    return this.customermanagement.findAllCustomers();
  }

  @Override
  public CustomerCto getCustomerCto(long id) {

    return this.customermanagement.findCustomerCto(id);
  }

  @Override
  public Page<CustomerCto> findCustomerCtos(CustomerSearchCriteriaTo searchCriteriaTo) {

    return this.customermanagement.findCustomerCtos(searchCriteriaTo);
  }

}
