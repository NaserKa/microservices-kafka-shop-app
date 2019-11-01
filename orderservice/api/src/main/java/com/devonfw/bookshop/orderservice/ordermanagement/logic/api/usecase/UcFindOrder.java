package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderCto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderSearchCriteriaTo;

public interface UcFindOrder {

  /**
   * Returns a composite Order by its id 'id'.
   *
   * @param id The id 'id' of the Order.
   * @return The {@link OrderEto} with id 'id'
   */
  OrderCto findOrder(long id);

  /**
   * Returns a paginated list of composite Orders matching the search criteria.
   *
   * @param criteria the {@link OrderSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OrderEto}s.
   */
  Page<OrderEto> findOrders(OrderSearchCriteriaTo criteria);

  /**
   * Returns a List of all Orders.
   *
   * @param
   * @return the {@link List} of all {@link OrderCto}s.
   */
  List<OrderCto> findAllOrders();

}
