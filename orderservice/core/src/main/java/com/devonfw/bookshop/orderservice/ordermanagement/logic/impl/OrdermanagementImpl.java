package com.devonfw.bookshop.orderservice.ordermanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.orderservice.general.logic.base.AbstractComponentFacade;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.Ordermanagement;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrderItem;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrderItem;

/**
 * Implementation of component interface of ordermanagement
 */

@Named
public class OrdermanagementImpl extends AbstractComponentFacade implements Ordermanagement {

  @Inject
  private UcFindOrderItem ucFindOrderItem;

  @Inject
  private UcManageOrderItem ucManageOrderItem;

  @Inject
  private UcFindOrder ucFindOrder;

  @Inject
  private UcManageOrder ucManageOrder;

  @Override
  public OrderItemEto findOrderItem(long id) {

    return this.ucFindOrderItem.findOrderItem(id);
  }

  @Override
  public Page<OrderItemEto> findOrderItems(OrderItemSearchCriteriaTo criteria) {

    return this.ucFindOrderItem.findOrderItems(criteria);
  }

  @Override
  public List<OrderItemCto> findAllOrderItems() {

    return this.ucFindOrderItem.findAllOrderItems();
  }

  @Override
  public OrderCto findOrder(long id) {

    return this.ucFindOrder.findOrder(id);
  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    return this.ucFindOrder.findOrders(criteria);
  }

  @Override
  public List<OrderCto> findAllOrders() {

    return this.ucFindOrder.findAllOrders();
  }

  @Override
  public boolean deleteOrderItem(long orderItemId) {

    return this.ucManageOrderItem.deleteOrderItem(orderItemId);
  }

  @Override
  public OrderItemEto saveOrderItem(long id, OrderItemEto orderItem) {

    return this.ucManageOrderItem.saveOrderItem(id, orderItem);
  }

  @Override
  public boolean deleteOrder(long orderId) {

    return this.ucManageOrder.deleteOrder(orderId);
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    return this.ucManageOrder.saveOrder(order);
  }

}
