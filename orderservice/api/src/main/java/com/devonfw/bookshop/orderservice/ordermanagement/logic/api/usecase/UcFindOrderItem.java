package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemSearchCriteriaTo;

public interface UcFindOrderItem {

  /**
   * Returns a composite OrderItem by its id 'id'.
   *
   * @param id The id 'id' of the OrderItem.
   * @return The {@link OrderItemEto} with id 'id'
   */
  OrderItemEto findOrderItem(long id);

  /**
   * Returns a paginated list of composite OrderItems matching the search criteria.
   *
   * @param criteria the {@link OrderItemSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderItemEto}s.
   */
  Page<OrderItemEto> findOrderItems(OrderItemSearchCriteriaTo criteria);

  /**
   * Returns a List of all OrderItems.
   *
   * @param
   * @return the {@link List} of all {@link OrderItemCto}s.
   */
  List<OrderItemCto> findAllOrderItems();
}
