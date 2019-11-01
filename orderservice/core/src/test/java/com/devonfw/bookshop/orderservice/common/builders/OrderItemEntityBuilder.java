package com.devonfw.bookshop.orderservice.common.builders;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderItemEntity;

/**
 * Test data builder for OrderItemEntity generated with cobigen.
 */
public class OrderItemEntityBuilder {

  private List<Consumer<OrderItemEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public OrderItemEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param order the order to add.
   * @return the builder for fluent population of fields.
   */
  public OrderItemEntityBuilder order(final OrderEntity order) {

    this.parameterToBeApplied.add(target -> target.setOrder(order));

    return this;
  }

  /**
   * @param name the name to add.
   * @return the builder for fluent population of fields.
   */
  public OrderItemEntityBuilder name(final String name) {

    this.parameterToBeApplied.add(target -> target.setName(name));

    return this;
  }

  /**
   * @param price the price to add.
   * @return the builder for fluent population of fields.
   */
  public OrderItemEntityBuilder price(final BigDecimal price) {

    this.parameterToBeApplied.add(target -> target.setPrice(price));

    return this;
  }

  /**
   * @param quantity the quantity to add.
   * @return the builder for fluent population of fields.
   */
  public OrderItemEntityBuilder quantity(final Integer quantity) {

    this.parameterToBeApplied.add(target -> target.setQuantity(quantity));

    return this;
  }

  /**
   * @param productId the productId to add.
   * @return the builder for fluent population of fields.
   */
  public OrderItemEntityBuilder productId(final long productId) {

    this.parameterToBeApplied.add(target -> target.setProductId(productId));

    return this;
  }

  /**
   * @return the populated OrderItemEntity.
   */
  public OrderItemEntity createNew() {

    OrderItemEntity orderitementity = new OrderItemEntity();
    for (Consumer<OrderItemEntity> parameter : parameterToBeApplied) {
      parameter.accept(orderitementity);
    }
    return orderitementity;
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
   * @return the OrderItemEntity
   */
  public OrderItemEntity persist(EntityManager em) {

    OrderItemEntity orderitementity = createNew();
    em.persist(orderitementity);
    return orderitementity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of OrderItemEntity
   */
  public List<OrderItemEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<OrderItemEntity> orderitementityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      OrderItemEntity orderitementity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(orderitementity);
      orderitementityList.add(orderitementity);
    }

    return orderitementityList;
  }

}
