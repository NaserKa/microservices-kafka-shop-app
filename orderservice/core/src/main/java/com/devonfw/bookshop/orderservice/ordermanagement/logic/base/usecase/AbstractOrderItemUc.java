package com.devonfw.bookshop.orderservice.ordermanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.bookshop.orderservice.general.logic.base.AbstractUc;
import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.repo.OrderItemRepository;
import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.repo.OrderRepository;

/**
 * Abstract use case for OrderItems, which provides access to the commonly necessary data access objects.
 */
public class AbstractOrderItemUc extends AbstractUc {

  /** @see #getOrderItemRepository() */
  @Inject
  private OrderItemRepository orderItemRepository;

  /** @see #getOrderRepository() */
  @Inject
  private OrderRepository orderRepository;

  /**
   * Returns the field 'orderItemRepository'.
   *
   * @return the {@link OrderItemRepository} instance.
   */
  public OrderItemRepository getOrderItemRepository() {

    return this.orderItemRepository;
  }

  /**
   * Returns the field 'orderRepository'.
   *
   * @return the {@link OrderRepository} instance.
   */
  public OrderRepository getOrderRepository() {

    return this.orderRepository;
  }

}
