package com.devonfw.bookshop.customerservice.customermanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.customerservice.customermanagement.logic.api.Customermanagement;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerCto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase.UcFindCustomer;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase.UcManageCustomer;
import com.devonfw.bookshop.customerservice.general.logic.base.AbstractComponentFacade;

import java.util.List;

/**
 * Implementation of component interface of customermanagement
 */
@Named
public class CustomermanagementImpl extends AbstractComponentFacade implements Customermanagement {

  @Inject
  private UcFindCustomer ucFindCustomer;

  @Inject
  private UcManageCustomer ucManageCustomer;

  @Override
  public CustomerEto findCustomer(long id) {

    return this.ucFindCustomer.findCustomer(id);
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {

    return this.ucFindCustomer.findCustomers(criteria);
  }

  @Override
  public CustomerEto saveCustomer(CustomerEto customer) {

    return this.ucManageCustomer.saveCustomer(customer);
  }

  @Override
  public CustomerEto updateCustomer(long id, CustomerEto customer) {
    return this.ucManageCustomer.updateCustomer(id, customer);
  }

  @Override
  public boolean deleteCustomer(long id) {

    return this.ucManageCustomer.deleteCustomer(id);
  }

  @Override
  public CustomerCto findCustomerCto(long id) {

    return ucFindCustomer.findCustomerCto(id);
  }

  @Override
  public Page<CustomerCto> findCustomerCtos(CustomerSearchCriteriaTo criteria) {

    return ucFindCustomer.findCustomerCtos(criteria);
  }

  @Override
  public List<CustomerCto> findAllCustomers() {
    return ucFindCustomer.findAllCustomers();
  }

}
