package com.devonfw.bookshop.paymentservice.common.builders;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.bookshop.paymentservice.paymentmanagement.dataaccess.api.PaymentEntity;

/**
 * Test data builder for PaymentEntity generated with cobigen.
 */
public class PaymentEntityBuilder {

  private List<Consumer<PaymentEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public PaymentEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param orderId the orderId to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder orderId(final long orderId) {

    this.parameterToBeApplied.add(target -> target.setOrderId(orderId));

    return this;
  }

  /**
   * @param paid the paid to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder paid(final boolean paid) {

    this.parameterToBeApplied.add(target -> target.setPaid(paid));

    return this;
  }

  /**
   * @param paymentDate the paymentDate to add.
   * @return the builder for fluent population of fields.
   */
  public PaymentEntityBuilder paymentDate(final Instant paymentDate) {

    this.parameterToBeApplied.add(target -> target.setPaymentDate(paymentDate));

    return this;
  }

  /**
   * @return the populated PaymentEntity.
   */
  public PaymentEntity createNew() {

    PaymentEntity paymententity = new PaymentEntity();
    for (Consumer<PaymentEntity> parameter : parameterToBeApplied) {
      parameter.accept(paymententity);
    }
    return paymententity;
  }

  /**
   * Might be enriched to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

  /**
   * @param em the {@link EntityManager}
   * @return the PaymentEntity
   */
  public PaymentEntity persist(EntityManager em) {

    PaymentEntity paymententity = createNew();
    em.persist(paymententity);
    return paymententity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of PaymentEntity
   */
  public List<PaymentEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<PaymentEntity> paymententityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      PaymentEntity paymententity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(paymententity);
      paymententityList.add(paymententity);
    }

    return paymententityList;
  }

}
