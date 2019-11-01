package com.devonfw.bookshop.orderservice.ordermanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderItemEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrderItem;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.base.usecase.AbstractOrderItemUc;

/**
 * Use case implementation for modifying and deleting OrderItems
 */
@Named
@Validated
@Transactional
public class UcManageOrderItemImpl extends AbstractOrderItemUc implements UcManageOrderItem {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderItemImpl.class);

  @Override
  public boolean deleteOrderItem(long orderItemId) {

    OrderItemEntity orderItem = getOrderItemRepository().find(orderItemId);
    getOrderItemRepository().delete(orderItem);
    LOG.debug("The orderItem with id '{}' has been deleted.", orderItemId);
    return true;
  }

  @Override
  public OrderItemEto saveOrderItem(long id, OrderItemEto orderItem) {

    Objects.requireNonNull(orderItem, "orderItem");

    OrderItemEntity orderItemEntity = getBeanMapper().map(orderItem, OrderItemEntity.class);

    // initialize, validate orderItemEntity here if necessary
    OrderItemEntity resultEntity = getOrderRepository().findById(id).map(order -> {
      orderItemEntity.setOrder(order);
      return getOrderItemRepository().save(orderItemEntity);
    }).orElseThrow(() -> new IllegalArgumentException("order not found"));

    LOG.debug("OrderItem with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, OrderItemEto.class);
  }
}
