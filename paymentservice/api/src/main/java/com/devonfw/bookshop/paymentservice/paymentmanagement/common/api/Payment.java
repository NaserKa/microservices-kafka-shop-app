package com.devonfw.bookshop.paymentservice.paymentmanagement.common.api;

import java.time.Instant;

import com.devonfw.bookshop.paymentservice.general.common.api.ApplicationEntity;

/**
 * @author nkazimi
 *
 */
public interface Payment extends ApplicationEntity {

  public long getOrderId();

  public void setOrderId(long orderId);

  public boolean getPaid();

  public void setPaid(boolean paid);

  public Instant getPaymentDate();

  public void setPaymentDate(Instant paymentDate);

  public Long getId();

  public void setId(Long id);

}
