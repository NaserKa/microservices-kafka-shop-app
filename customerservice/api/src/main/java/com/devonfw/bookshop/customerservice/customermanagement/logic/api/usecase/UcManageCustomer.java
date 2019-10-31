package com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase;

import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;

import javax.ws.rs.PathParam;

/**
 * Interface of UcManageCustomer to centralize documentation and signatures of methods.
 */
public interface UcManageCustomer {

  /**
   * Deletes a customer from the database by its id 'customerId'.
   *
   * @param customerId Id of the customer to delete
   * @return boolean <code>true</code> if the customer can be deleted, <code>false</code> otherwise
   */
  boolean deleteCustomer(long customerId);

  /**
   * Saves a customer and store it in the database.
   *
   * @param customer the {@link CustomerEto} to create.
   * @return the new {@link CustomerEto} that has been saved with ID and version.
   */
  CustomerEto saveCustomer(CustomerEto customer);

  /**
   * Updates a customer and store it in the database.
   *
   * @param customer the {@link CustomerEto} to create.
   * @return the new {@link CustomerEto} that has been saved with ID and version.
   */
  CustomerEto updateCustomer(long id, CustomerEto customer);
}
