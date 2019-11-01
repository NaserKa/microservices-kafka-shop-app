package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.impl.usecase;

import java.time.Instant;
import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.PaymentEntity;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase.UcManagePayment;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.base.usecase.AbstractPaymentUc;

/**
 * Use case implementation for modifying and deleting Payments
 */
@Named
@Validated
@Transactional
public class UcManagePaymentImpl extends AbstractPaymentUc implements UcManagePayment {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManagePaymentImpl.class);

  @Override
  public boolean deletePayment(long paymentId) {

    PaymentEntity payment = getPaymentRepository().find(paymentId);
    getPaymentRepository().delete(payment);
    LOG.debug("The payment with id '{}' has been deleted.", paymentId);
    return true;
  }

  @Override
  public PaymentEto savePayment(PaymentEto payment) {

    Objects.requireNonNull(payment, "payment");

    PaymentEntity paymentEntity = getBeanMapper().map(payment, PaymentEntity.class);

    // initialize, validate paymentEntity here if necessary
    PaymentEntity resultEntity = getPaymentRepository().save(paymentEntity);
    LOG.debug("Payment with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, PaymentEto.class);
  }

  @Override
  public void savePaymentById(long orderId) {
    Objects.requireNonNull(orderId, "orderId");

    PaymentEntity paymentEntity = new PaymentEntity();
    paymentEntity.setPaymentDate(Instant.now());
    paymentEntity.setPaid(false);
    paymentEntity.setOrderId(orderId);

    // initialize, validate paymentEntity here if necessary
    PaymentEntity resultEntity = getPaymentRepository().save(paymentEntity);
    LOG.debug("Payment with id '{}' has been created.", resultEntity.getId());
  }

  @Override
  public PaymentEto payForIncomingOrder(long orderId) {
    PaymentEntity paymentEntity = getPaymentRepository().findPaymentByOrderId(orderId);
    LOG.debug("Payment for incoming Order");
    LOG.info(paymentEntity.getId().toString());
    paymentEntity.setPaid(true);

    // initialize, validate paymentEntity here if necessary
    PaymentEntity resultEntity = getPaymentRepository().save(paymentEntity);
    LOG.debug("Payment for orderId '{}' has been created.", resultEntity.getOrderId());
    return getBeanMapper().map(resultEntity, PaymentEto.class);
  }

  @Override
  public PaymentEto updatePayment(long id, PaymentEto payment) {
    Objects.requireNonNull(payment, "customer");

    LOG.debug("Get Product with id {} from database.", id);
    PaymentEntity paymentEntity = getPaymentRepository().find(id);
    paymentEntity.setOrderId(payment.getOrderId());
    paymentEntity.setPaid(payment.getPaid());
    paymentEntity.setPaymentDate(payment.getPaymentDate());

    PaymentEntity resultEntity = getPaymentRepository().save(paymentEntity);
    LOG.debug("Product with id '{}' has been updated.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, PaymentEto.class);
  }
}
