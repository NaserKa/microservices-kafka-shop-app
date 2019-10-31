package com.devonfw.bookshop.customerservice.common.builders;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.CustomerEntity;

/**
 * Test data builder for CustomerEntity generated with cobigen.
 */
public class CustomerEntityBuilder {

  private List<Consumer<CustomerEntity>> parameterToBeApplied;

  /**
   * The constructor.
   */
  public CustomerEntityBuilder() {

    this.parameterToBeApplied = new LinkedList<>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  /**
   * @param name the name to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder name(final String name) {

    this.parameterToBeApplied.add(target -> target.setName(name));

    return this;
  }

  /**
   * @param lastname the lastname to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder lastname(final String lastname) {

    this.parameterToBeApplied.add(target -> target.setLastname(lastname));

    return this;
  }

  /**
   * @param adress the adress to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder adress(final String adress) {

    this.parameterToBeApplied.add(target -> target.setAdress(adress));

    return this;
  }

  /**
   * @param city the city to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder city(final String city) {

    this.parameterToBeApplied.add(target -> target.setCity(city));

    return this;
  }

  /**
   * @param lastChange the lastChange to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder lastChange(final Instant lastChange) {

    this.parameterToBeApplied.add(target -> target.setLastChange(lastChange));

    return this;
  }

  /**
   * @param customerNumber the customerNumber to add.
   * @return the builder for fluent population of fields.
   */
  public CustomerEntityBuilder customerNumber(final Integer customerNumber) {

    this.parameterToBeApplied.add(target -> target.setCustomerNumber(customerNumber));

    return this;
  }

  /**
   * @return the populated CustomerEntity.
   */
  public CustomerEntity createNew() {

    CustomerEntity customerentity = new CustomerEntity();
    for (Consumer<CustomerEntity> parameter : parameterToBeApplied) {
      parameter.accept(customerentity);
    }
    return customerentity;
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

    // TODO lastChange(...); //set Default java.time.Instant
  }

  /**
   * @param em the {@link EntityManager}
   * @return the CustomerEntity
   */
  public CustomerEntity persist(EntityManager em) {

    CustomerEntity customerentity = createNew();
    em.persist(customerentity);
    return customerentity;
  }

  /**
   * @param em the {@link EntityManager}
   * @param quantity the quantity
   * @return a list of CustomerEntity
   */
  public List<CustomerEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<CustomerEntity> customerentityList = new LinkedList<>();
    for (int i = 0; i < quantity; i++) {
      CustomerEntity customerentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(customerentity);
      customerentityList.add(customerentity);
    }

    return customerentityList;
  }

}
