package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to;

import java.time.Instant;

import com.devonfw.bookshop.paymentservice.paymentmanagement.common.api.Payment;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Payment
 */
public class PaymentEto extends AbstractEto implements Payment {

  private static final long serialVersionUID = 1L;

  private long orderId;

  private boolean paid;

  private Instant paymentDate;

  @Override
  public long getOrderId() {

    return orderId;
  }

  @Override
  public void setOrderId(long orderId) {

    this.orderId = orderId;
  }

  @Override
  public boolean getPaid() {
    return paid;
  }

  @Override
  public void setPaid(boolean paid) {

    this.paid = paid;
  }

  @Override
  public Instant getPaymentDate() {

    return paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((Long) orderId).hashCode();
    result = prime * result + ((Boolean) paid).hashCode();
    result = prime * result + ((this.paymentDate == null) ? 0 : this.paymentDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    PaymentEto other = (PaymentEto) obj;
    if (this.orderId != other.orderId) {
      return false;
    }
    if (this.paid != other.paid) {
      return false;
    }
    if (this.paymentDate == null) {
      if (other.paymentDate != null) {
        return false;
      }
    } else if (!this.paymentDate.equals(other.paymentDate)) {
      return false;
    }
    return true;
  }
}
