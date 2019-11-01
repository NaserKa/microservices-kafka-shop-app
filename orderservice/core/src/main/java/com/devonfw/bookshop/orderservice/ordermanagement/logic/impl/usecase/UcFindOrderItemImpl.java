package com.devonfw.bookshop.orderservice.ordermanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderItemEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrderItem;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.base.usecase.AbstractOrderItemUc;

/**
 * Use case implementation for searching, filtering and getting OrderItems
 */
@Named
@Validated
@Transactional
public class UcFindOrderItemImpl extends AbstractOrderItemUc implements UcFindOrderItem {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderItemImpl.class);

  @Override
  public OrderItemEto findOrderItem(long id) {

    LOG.debug("Get OrderItem with id {} from database.", id);
    Optional<OrderItemEntity> foundEntity = getOrderItemRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), OrderItemEto.class);
    else
      return null;
  }

  @Override
  public Page<OrderItemEto> findOrderItems(OrderItemSearchCriteriaTo criteria) {

    Page<OrderItemEntity> orderitems = getOrderItemRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(orderitems, OrderItemEto.class);
  }

  @Override
  public List<OrderItemCto> findAllOrderItems() {

    List<OrderItemEntity> orderItems = getOrderItemRepository().findAll();
    List<OrderItemCto> ctos = new ArrayList<>();
    for (OrderItemEntity entity : orderItems) {
      OrderItemCto cto = new OrderItemCto();
      cto.setOrderItem(getBeanMapper().map(entity, OrderItemEto.class));
      ctos.add(cto);
    }

    return ctos;
  }
}
