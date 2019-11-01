package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderItemEto;

/**
 * Interface of UcManageOrderItem to centralize documentation and signatures of methods.
 */
public interface UcManageOrderItem {

  /**
   * Deletes a orderItem from the database by its id 'orderItemId'.
   *
   * @param orderItemId Id of the orderItem to delete
   * @return boolean <code>true</code> if the orderItem can be deleted, <code>false</code> otherwise
   */
  boolean deleteOrderItem(long orderItemId);

  /**
   * Saves a orderItem and store it in the database.
   *
   * @param orderItem the {@link OrderItemEto} to create.
   * @return the new {@link OrderItemEto} that has been saved with ID and version.
   */
  OrderItemEto saveOrderItem(long id, OrderItemEto orderItem);

}
