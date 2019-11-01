package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of OrderItem
 */
public class OrderItemCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OrderItemEto orderItem;

  private OrderEto order;

  public OrderItemEto getOrderItem() {

    return orderItem;
  }

  public void setOrderItem(OrderItemEto orderItem) {

    this.orderItem = orderItem;
  }

  public OrderEto getOrder() {

    return order;
  }

  public void setOrder(OrderEto order) {

    this.order = order;
  }

}
