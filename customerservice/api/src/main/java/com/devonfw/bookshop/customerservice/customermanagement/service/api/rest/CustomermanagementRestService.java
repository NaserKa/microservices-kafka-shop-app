package com.devonfw.bookshop.customerservice.customermanagement.service.api.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.customerservice.customermanagement.logic.api.Customermanagement;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerCto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;

import java.util.List;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Customermanagement}.
 */
@Path("/customermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CustomermanagementRestService {

  /**
   * Delegates to {@link Customermanagement#findCustomer}.
   *
   * @param id the ID of the {@link CustomerEto}
   * @return the {@link CustomerEto}
   */
  @GET
  @Path("/customer/{id}/")
  public CustomerEto getCustomer(@PathParam("id") long id);

  /**
   * Delegates to {@link Customermanagement#saveCustomer}.
   *
   * @param customer the {@link CustomerEto} to be saved
   * @return the recently created {@link CustomerEto}
   */
  @POST
  @Path("/customer/")
  public CustomerEto saveCustomer(CustomerEto customer);

  /**
   * Delegates to {@link Customermanagement#updateCustomer}.
   *
   * @param id,customer the {@link CustomerEto} to be saved
   * @return the recently created {@link CustomerEto}
   */
  @PUT
  @Path("/customer/{id}")
  public CustomerEto updateCustomer(@PathParam("id") long id, CustomerEto customer);

  /**
   * Delegates to {@link Customermanagement#deleteCustomer}.
   *
   * @param id ID of the {@link CustomerEto} to be deleted
   */
  @DELETE
  @Path("/customer/{id}/")
  public void deleteCustomer(@PathParam("id") long id);

  /**
   * Delegates to {@link Customermanagement#findCustomerEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding customers.
   * @return the {@link Page list} of matching {@link CustomerEto}s.
   */
  @Path("/customer/search")
  @POST
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Customermanagement#findAllCustomers}.
   *
   * @param
   * @return the {@link List CustomerCto} of all entrys.
   */
  @GET
  @Path("/customer/")
  public List<CustomerCto> findAllCustomers();

  /**
   * @param id
   * @return
   */
  CustomerCto getCustomerCto(long id);

  /**
   * @param searchCriteriaTo
   * @return
   */
  Page<CustomerCto> findCustomerCtos(CustomerSearchCriteriaTo searchCriteriaTo);

}
