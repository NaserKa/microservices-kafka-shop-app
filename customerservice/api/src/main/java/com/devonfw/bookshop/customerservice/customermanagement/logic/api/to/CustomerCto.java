package com.devonfw.bookshop.customerservice.customermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Customer
 */
public class CustomerCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private CustomerEto customer;

  public CustomerEto getCustomer() {

    return customer;
  }

  public void setCustomer(CustomerEto customer) {

    this.customer = customer;
  }

}
