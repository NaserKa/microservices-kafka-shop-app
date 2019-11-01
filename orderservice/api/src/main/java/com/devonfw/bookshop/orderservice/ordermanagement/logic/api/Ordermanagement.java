package com.devonfw.bookshop.orderservice.ordermanagement.logic.api;

import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcFindOrderItem;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrderItem;

/**
 * Interface for Ordermanagement component.
 */
public interface Ordermanagement extends UcFindOrderItem, UcFindOrder, UcManageOrderItem, UcManageOrder {

}
