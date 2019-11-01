package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.orderservice.ordermanagement.common.api.Order;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Order
 */
public class OrderEto extends AbstractEto implements Order {

  private static final long serialVersionUID = 1L;

  private long customerId;

  private boolean paid;

  private BigDecimal totalPrice;

  private Instant orderDate;

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result;
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
    OrderEto other = (OrderEto) obj;
    return true;
  }

  @Override
  public long getCustomerId() {

    return this.customerId;
  }

  @Override
  public void setCustomerId(long customerId) {

    this.customerId = customerId;
  }

  @Override
  public boolean isPaid() {

    return this.paid;
  }

  @Override
  public void setPaid(boolean paid) {

    this.paid = paid;
  }

  @Override
  public BigDecimal getTotalPrice() {

    return this.totalPrice;
  }

  @Override
  public void setTotalPrice(BigDecimal totalPrice) {

    this.totalPrice = totalPrice;
  }

  @Override
  public Instant getOrderDate() {

    return this.orderDate;
  }

  @Override
  public void setOrderDate(Instant orderDate) {

    this.orderDate = orderDate;
  }
}
