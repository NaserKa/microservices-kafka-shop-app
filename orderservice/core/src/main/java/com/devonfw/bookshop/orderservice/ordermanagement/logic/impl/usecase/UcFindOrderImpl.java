package com.devonfw.bookshop.orderservice.ordermanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.base.usecase.AbstractOrderUc;

/**
 * Use case implementation for searching, filtering and getting Orders
 */
@Named
@Validated
@Transactional
public class UcFindOrderImpl extends AbstractOrderUc implements UcFindOrder {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindOrderImpl.class);

  @Override
  public OrderCto findOrder(long id) {

    LOG.debug("Get Order with id {} from database.", id);

    OrderEntity entity = getOrderRepository().find(id);
    OrderCto cto = new OrderCto();
    cto.setOrderItems(getBeanMapper().mapList(entity.getOrderItems(), OrderItemCto.class));
    cto.setOrder(getBeanMapper().map(entity, OrderEto.class));
    return cto;

  }

  @Override
  public Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria) {

    Page<OrderEntity> orders = getOrderRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(orders, OrderEto.class);
  }

  @Override
  public List<OrderCto> findAllOrders() {

    List<OrderEntity> orders = getOrderRepository().findAllOrder();
    List<OrderCto> ctos = new ArrayList<>();
    for (OrderEntity entity : orders) {
      OrderCto cto = new OrderCto();
      cto.setOrder(getBeanMapper().map(entity, OrderEto.class));
      ctos.add(cto);
    }

    return ctos;
  }

}
