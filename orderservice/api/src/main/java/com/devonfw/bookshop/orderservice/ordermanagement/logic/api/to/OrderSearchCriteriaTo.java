package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.orderservice.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.bookshop.orderservice.ordermanagement.common.api.Order}s.
 */
public class OrderSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long customerId;

  private Boolean paid;

  private BigDecimal totalPrice;

  private Instant orderDate;

  /**
   * @return customerIdId
   */

  public Long getCustomerId() {

    return customerId;
  }

  /**
   * @param customerId setter for customerId attribute
   */

  public void setCustomerId(Long customerId) {

    this.customerId = customerId;
  }

  /**
   * @return paidId
   */

  public Boolean getPaid() {

    return paid;
  }

  /**
   * @param paid setter for paid attribute
   */

  public void setPaid(Boolean paid) {

    this.paid = paid;
  }

  /**
   * @return totalPriceId
   */

  public BigDecimal getTotalPrice() {

    return totalPrice;
  }

  /**
   * @param totalPrice setter for totalPrice attribute
   */

  public void setTotalPrice(BigDecimal totalPrice) {

    this.totalPrice = totalPrice;
  }

  /**
   * @return orderDateId
   */

  public Instant getOrderDate() {

    return orderDate;
  }

  /**
   * @param orderDate setter for orderDate attribute
   */

  public void setOrderDate(Instant orderDate) {

    this.orderDate = orderDate;
  }

}
