package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.paymentservice.general.logic.base.AbstractComponentFacade;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.Paymentmanagement;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentCto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase.UcManagePayment;

import java.util.List;

/**
 * Implementation of component interface of paymentmanagement
 */
@Named
public class PaymentmanagementImpl extends AbstractComponentFacade implements Paymentmanagement {

  @Inject
  private UcFindPayment ucFindPayment;

  @Inject
  private UcManagePayment ucManagePayment;

  @Override
  public PaymentEto findPayment(long id) {

    return this.ucFindPayment.findPayment(id);
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria) {

    return this.ucFindPayment.findPayments(criteria);
  }

  @Override
  public List<PaymentCto> findAllPayments() {
    return this.ucFindPayment.findAllPayments();
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    return this.ucManagePayment.savePayment(payment);
  }

  @Override
  public void savePaymentById(long orderId) {
    this.ucManagePayment.savePaymentById(orderId);
  }

  @Override
  public PaymentEto payForIncomingOrder(long orderId) {
    return this.ucManagePayment.payForIncomingOrder(orderId);
  }

  @Override
  public PaymentEto updatePayment(long id, PaymentEto payment) {
    return this.ucManagePayment.updatePayment(id, payment);
  }

  @Override
  public boolean deletePayment(long id) {

    return this.ucManagePayment.deletePayment(id);
  }
}
