package com.devonfw.bookshop.orderservice.ordermanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.Ordermanagement;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.service.api.rest.OrdermanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ordermanagement}.
 */
@Named("OrdermanagementRestService")
public class OrdermanagementRestServiceImpl implements OrdermanagementRestService {

  @Inject
  private Ordermanagement ordermanagement;

  @Override
  public OrderItemEto getOrderItem(long id) {

    return this.ordermanagement.findOrderItem(id);
  }

  @Override
  public Page<OrderItemEto> findOrderItems(OrderItemSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrderItems(searchCriteriaTo);
  }

  @Override
  public OrderCto getOrder(long id) {

    return this.ordermanagement.findOrder(id);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ordermanagement.saveOrder(order);
  }

  @Override
  public OrderItemEto saveOrder(long id, OrderItemEto order) {

    return this.ordermanagement.saveOrderItem(id, order);
  }

  @Override
  public void deleteOrder(long id) {

    this.ordermanagement.deleteOrder(id);
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo searchCriteriaTo) {

    return this.ordermanagement.findOrders(searchCriteriaTo);
  }

  @Override
  public void deleteOrderItem(long id) {

    this.ordermanagement.deleteOrderItem(id);
  }

  @Override
  public List<OrderCto> findAllOrders() {

    return this.ordermanagement.findAllOrders();
  }

}
