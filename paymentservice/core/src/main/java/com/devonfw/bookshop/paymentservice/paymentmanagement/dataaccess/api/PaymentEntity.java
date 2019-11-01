package com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.devonfw.bookshop.paymentservice.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.bookshop.paymentservice.paymentmanagement.common.api.Payment;

/**
 * @author nkazimi
 *
 */

@Entity
@Table(name = "Payment")
public class PaymentEntity extends ApplicationPersistenceEntity implements Payment {

  private static final long serialVersionUID = 1L;

  private Long id;

  private long orderId;

  private boolean paid;

  private Instant paymentDate;

  @Override
  public long getOrderId() {

    return this.orderId;
  }

  @Override
  public void setOrderId(long orderId) {

    this.orderId = orderId;
  }

  @Override
  public boolean getPaid() {

    return this.paid;
  }

  @Override
  public void setPaid(boolean paid) {

    this.paid = paid;
  }

  @Override
  public Instant getPaymentDate() {

    return this.paymentDate;
  }

  @Override
  public void setPaymentDate(Instant paymentDate) {

    this.paymentDate = paymentDate;
  }

  @Override
  @Id
  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
