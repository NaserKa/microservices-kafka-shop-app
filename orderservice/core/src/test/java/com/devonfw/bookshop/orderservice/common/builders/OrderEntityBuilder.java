package com.devonfw.bookshop.orderservice.common.builders;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderItemEntity;

/**
 * Test data builder for OrderEntity generated with cobigen.
 */
public class OrderEntityBuilder {

  private List<Consumer<OrderEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public OrderEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param orderItems the orderItems to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder orderItems(final List<OrderItemEntity> orderItems) {

    this.parameterToBeApplied.add(target -> target.setOrderItems(orderItems));

    return this;
  }

  /**
   * @param customerId the customerId to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder customerId(final long customerId) {

    this.parameterToBeApplied.add(target -> target.setCustomerId(customerId));

    return this;
  }

  /**
   * @param paid the paid to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder paid(final boolean paid) {

    this.parameterToBeApplied.add(target -> target.setPaid(paid));

    return this;
  }

  /**
   * @param totalPrice the totalPrice to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder totalPrice(final BigDecimal totalPrice) {

    this.parameterToBeApplied.add(target -> target.setTotalPrice(totalPrice));

    return this;
  }

  /**
   * @param orderDate the orderDate to add.
   * @return the builder for fluent population of fields.
   */
  public OrderEntityBuilder orderDate(final Instant orderDate) {

    this.parameterToBeApplied.add(target -> target.setOrderDate(orderDate));

    return this;
  }

  /**
   * @return the populated OrderEntity.
   */
  public OrderEntity createNew() {

    OrderEntity orderentity = new OrderEntity();
    for (Consumer<OrderEntity> parameter : parameterToBeApplied) {
      parameter.accept(orderentity);
    }
    return orderentity;
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
   * @return the OrderEntity
   */
  public OrderEntity persist(EntityManager em) {

    OrderEntity orderentity = createNew();
    em.persist(orderentity);
    return orderentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of OrderEntity
   */
  public List<OrderEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<OrderEntity> orderentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      OrderEntity orderentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(orderentity);
      orderentityList.add(orderentity);
    }

    return orderentityList;
  }

}
