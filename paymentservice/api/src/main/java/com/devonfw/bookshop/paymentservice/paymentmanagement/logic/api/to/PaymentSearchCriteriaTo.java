package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to;

import java.time.Instant;

import com.devonfw.bookshop.paymentservice.general.common.api.to.AbstractSearchCriteriaTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.bookshop.paymentservice.paymentmanagement.common.api.Payment}s.
 */
public class PaymentSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long orderId;

  private Boolean paid;

  private Instant paymentDate;

  /**
   * @return orderIdId
   */

  public Long getOrderId() {

    return orderId;
  }

  /**
   * @param orderId setter for orderId attribute
   */

  public void setOrderId(Long orderId) {

    this.orderId = orderId;
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
   * @return paymentDateId
   */

  public Instant getPaymentDate() {

    return paymentDate;
  }

  /**
   * @param paymentDate setter for paymentDate attribute
   */

  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

}
