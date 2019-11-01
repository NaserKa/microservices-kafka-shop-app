package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.PaymentEntity;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentCto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase.UcFindPayment;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.base.usecase.AbstractPaymentUc;

/**
 * Use case implementation for searching, filtering and getting Payments
 */
@Named
@Validated
@Transactional
public class UcFindPaymentImpl extends AbstractPaymentUc implements UcFindPayment {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindPaymentImpl.class);

  @Override
  public PaymentEto findPayment(long id) {

    LOG.debug("Get Payment with id {} from database.", id);
    Optional<PaymentEntity> foundEntity = getPaymentRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), PaymentEto.class);
    else
      return null;
  }

  @Override
  public Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria) {

    Page<PaymentEntity> payments = getPaymentRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(payments, PaymentEto.class);
  }

  @Override
  public List<PaymentCto> findAllPayments() {
    List<PaymentEntity> payments = getPaymentRepository().findAll();
    List<PaymentCto> ctos = new ArrayList<>();
    for (PaymentEntity entity : payments) {
      PaymentCto cto = new PaymentCto();
      cto.setPayment(getBeanMapper().map(entity, PaymentEto.class));
      ctos.add(cto);
    }

    return ctos;
  }
}
