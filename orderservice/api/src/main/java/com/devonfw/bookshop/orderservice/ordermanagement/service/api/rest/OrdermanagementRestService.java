package com.devonfw.bookshop.orderservice.ordermanagement.service.api.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.Ordermanagement;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Path("/ordermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OrdermanagementRestService {

  @GET
  @Path("/orders")
  public List<OrderCto> findAllOrders();

  /**
   * Delegates to {@link Ordermanagement#findOrderItemCto}.
   *
   * @param id the ID of the {@link OrderItemEto}
   * @return the {@link OrderItemEto}
   */
  @GET
  @Path("/orderitem/{id}/")
  public OrderItemEto getOrderItem(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findOrderItemEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding orderitems.
   * @return the {@link Page list} of matching {@link OrderItemEto}s.
   */
  @Path("/orderitem/search")
  @POST
  public Page<OrderItemEto> findOrderItems(OrderItemSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Ordermanagement#findOrder}.
   *
   * @param id the ID of the {@link OrderEto}
   * @return the {@link OrderEto}
   */
  @GET
  @Path("/order/{id}/")
  public OrderCto getOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#saveOrder}.
   *
   * @param order the {@link OrderEto} to be saved
   * @return the recently created {@link OrderEto}
   */
  @POST
  @Path("/order/")
  public OrderEto saveOrder(OrderEto order);

  /**
   * Delegates to {@link Ordermanagement#saveOrder}.
   *
   * @param order the {@link OrderItemEto} to be saved
   * @return the recently created {@link OrderItemEto}
   */
  @POST
  @Path("/orders/{id}/orderitem/")
  public OrderItemEto saveOrder(@PathParam("id") long id, OrderItemEto order);

  /**
   * Delegates to {@link Ordermanagement#deleteOrder}.
   *
   * @param id ID of the {@link OrderEto} to be deleted
   */
  @DELETE
  @Path("/order/{id}/")
  public void deleteOrder(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#deleteOrderItem}.
   *
   * @param id ID of the {@link OrderItemEto} to be deleted
   */
  @DELETE
  @Path("/orderitem/{id}/")
  public void deleteOrderItem(@PathParam("id") long id);

  /**
   * Delegates to {@link Ordermanagement#findOrderEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding orders.
   * @return the {@link Page list} of matching {@link OrderEto}s.
   */
  @Path("/order/search")
  @POST
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo);

}
