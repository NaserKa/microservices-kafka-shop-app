package com.devonfw.bookshop.paymentservice.paymentmanagement.service.api.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentCto;
import org.springframework.data.domain.Page;

import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.Paymentmanagement;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;

import java.util.List;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Paymentmanagement}.
 */
@Path("/paymentmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PaymentmanagementRestService {

  /**
   * Delegates to {@link Paymentmanagement#findPayment}.
   *
   * @param id the ID of the {@link PaymentEto}
   * @return the {@link PaymentEto}
   */
  @GET
  @Path("/payment/{id}/")
  public PaymentEto getPayment(@PathParam("id") long id);

  /**
   * Delegates to {@link Paymentmanagement#savePayment}.
   *
   * @param payment the {@link PaymentEto} to be saved
   * @return the recently created {@link PaymentEto}
   */
  @POST
  @Path("/payment/")
  public PaymentEto savePayment(PaymentEto payment);

  /**
   * Delegates to {@link Paymentmanagement#savePayment}.
   *
   * @param orderId the {@link PaymentEto} to be updated
   * @return the recently created {@link PaymentEto}
   */
  @PUT
  @Path("/payment/{orderId}")
  public PaymentEto savePaymentById(@PathParam("orderId") long orderId);

  /**
   * Delegates to {@link Paymentmanagement#deletePayment}.
   *
   * @param id ID of the {@link PaymentEto} to be deleted
   */
  @DELETE
  @Path("/payment/{id}/")
  public void deletePayment(@PathParam("id") long id);

  /**
   * Delegates to {@link Paymentmanagement#findPayments}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding payments.
   * @return the {@link Page list} of matching {@link PaymentEto}s.
   */
  @Path("/payment/search")
  @POST
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo searchCriteriaTo);


  /**
   * Delegates to {@link Paymentmanagement#findAllPayments()}.
   *
   * @param
   * @return the {@link List PaymentCto} of all entrys.
   */
  @GET
  @Path("/payments/")
  public List<PaymentCto> findAllPayments();

  /**
   * Delegates to {@link Paymentmanagement#}.
   *
   * @param id,payment the {@link PaymentEto} to be saved
   * @return the recently created {@link PaymentEto}
   */
  @PUT
  @Path("/payment/{id}")
  public PaymentEto updatePayment(@PathParam("id") long id, PaymentEto payment);

}
