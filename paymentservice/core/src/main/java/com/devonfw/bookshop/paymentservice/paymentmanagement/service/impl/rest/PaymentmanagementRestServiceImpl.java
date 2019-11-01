package com.devonfw.bookshop.paymentservice.paymentmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.Paymentmanagement;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentCto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.devonfw.bookshop.paymentservice.paymentmanagement.service.api.rest.PaymentmanagementRestService;

import java.util.List;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Paymentmanagement}.
 */
@Named("PaymentmanagementRestService")
public class PaymentmanagementRestServiceImpl implements PaymentmanagementRestService {

  @Inject
  private Paymentmanagement paymentmanagement;

  @Override
  public PaymentEto getPayment(long id) {

    return this.paymentmanagement.findPayment(id);
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    return this.paymentmanagement.savePayment(payment);
  }

  @Override
  public PaymentEto savePaymentById(long orderId) {
    return this.paymentmanagement.payForIncomingOrder(orderId);
  }

  @Override
  public void deletePayment(long id) {

    this.paymentmanagement.deletePayment(id);
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo searchCriteriaTo) {

    return this.paymentmanagement.findPayments(searchCriteriaTo);
  }

  @Override
  public List<PaymentCto> findAllPayments() {
    return this.paymentmanagement.findAllPayments();
  }

  @Override
  public PaymentEto updatePayment(long id, PaymentEto payment) {
    return this.paymentmanagement.updatePayment(id, payment);
  }
}
