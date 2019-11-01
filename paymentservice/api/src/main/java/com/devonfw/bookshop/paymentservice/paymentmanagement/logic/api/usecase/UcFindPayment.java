package com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.usecase;

import java.util.List;

import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentEto;
import org.springframework.data.domain.Page;

import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentCto;
import com.devonfw.bookshop.paymentservice.paymentmanagement.logic.api.to.PaymentSearchCriteriaTo;

public interface UcFindPayment {

  /**
   * Returns a composite Payment by its id 'id'.
   *
   * @param id The id 'id' of the Payment.
   * @return The {@link PaymentCto} with id 'id'
   */
  PaymentEto findPayment(long id);

  /**
   * Returns a paginated list of composite Payments matching the search criteria.
   *
   * @param criteria the {@link PaymentSearchCriteriaTo}.
   * @return the {@link List} of matching {@link PaymentCto}s.
   */
  Page<PaymentEto> findPayments(PaymentSearchCriteriaTo criteria);

  /**
   * Returns a List of all Payments.
   *
   * @param
   * @return the {@link List} of all {@link PaymentCto}s.
   */
  List<PaymentCto> findAllPayments();

}
