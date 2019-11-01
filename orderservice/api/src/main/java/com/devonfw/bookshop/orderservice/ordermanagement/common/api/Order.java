package com.devonfw.bookshop.orderservice.ordermanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.orderservice.general.common.api.ApplicationEntity;

/**
 * @author nkazimi
 */
public interface Order extends ApplicationEntity {

  /**
   * @return customerIdId
   */
  public long getCustomerId();

  /**
   * @param customerId setter for customerId attribute
   */
  public void setCustomerId(long customerId);

  /**
   * @return paidId
   */
  public boolean isPaid();

  /**
   * @param paid setter for paid attribute
   */
  public void setPaid(boolean paid);

  /**
   * @return totalPriceId
   */
  public BigDecimal getTotalPrice();

  /**
   * @param totalPrice setter for totalPrice attribute
   */
  public void setTotalPrice(BigDecimal totalPrice);

  /**
   * @return orderDateId
   */
  public Instant getOrderDate();

  /**
   * @param orderDate setter for orderDate attribute
   */
  public void setOrderDate(Instant orderDate);

}
