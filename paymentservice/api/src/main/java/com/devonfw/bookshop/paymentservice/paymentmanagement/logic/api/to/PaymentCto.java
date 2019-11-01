package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Payment
 */
public class PaymentCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private PaymentEto payment;

  public PaymentEto getPayment() {

    return payment;
  }

  public void setPayment(PaymentEto payment) {

    this.payment = payment;
  }

}
