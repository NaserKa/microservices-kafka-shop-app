package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import java.util.List;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Order
 */
public class OrderCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OrderEto order;

  private List<OrderItemCto> orderItems;

  public OrderEto getOrder() {

    return this.order;
  }

  public void setOrder(OrderEto order) {

    this.order = order;
  }

  public List<OrderItemCto> getOrderItems() {

    return this.orderItems;
  }

  public void setOrderItems(List<OrderItemCto> orderItems) {

    this.orderItems = orderItems;
  }

}
