package com.devonfw.bookshop.customerservice.customermanagement.logic.api.to;

import java.time.Instant;

import com.devonfw.bookshop.customerservice.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.bookshop.customerservice.customermanagement.common.api.Customer}s.
 */
public class CustomerSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String lastname;

  private String adress;

  private String city;

  private Instant lastChange;

  private Integer customerNumber;

  private StringSearchConfigTo nameOption;

  private StringSearchConfigTo lastnameOption;

  private StringSearchConfigTo adressOption;

  private StringSearchConfigTo cityOption;

  /**
   * @return nameId
   */
  public String getName() {

    return name;
  }

  /**
   * @param name setter for name attribute
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return lastnameId
   */
  public String getLastname() {

    return lastname;
  }

  /**
   * @param lastname setter for lastname attribute
   */
  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  /**
   * @return adressId
   */
  public String getAdress() {

    return adress;
  }

  /**
   * @param adress setter for adress attribute
   */
  public void setAdress(String adress) {

    this.adress = adress;
  }

  /**
   * @return cityId
   */
  public String getCity() {

    return city;
  }

  /**
   * @param city setter for city attribute
   */
  public void setCity(String city) {

    this.city = city;
  }

  /**
   * @return lastChangeId
   */
  public Instant getLastChange() {

    return lastChange;
  }

  /**
   * @param lastChange setter for lastChange attribute
   */
  public void setLastChange(Instant lastChange) {

    this.lastChange = lastChange;
  }

  /**
   * @return customerNumberId
   */
  public Integer getCustomerNumber() {

    return customerNumber;
  }

  /**
   * @param customerNumber setter for customerNumber attribute
   */
  public void setCustomerNumber(Integer customerNumber) {

    this.customerNumber = customerNumber;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getName() name}.
   */
  public StringSearchConfigTo getNameOption() {

    return this.nameOption;
  }

  /**
   * @param nameOption new value of {@link #getNameOption()}.
   */
  public void setNameOption(StringSearchConfigTo nameOption) {

    this.nameOption = nameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getLastname() lastname}.
   */
  public StringSearchConfigTo getLastnameOption() {

    return this.lastnameOption;
  }

  /**
   * @param lastnameOption new value of {@link #getLastnameOption()}.
   */
  public void setLastnameOption(StringSearchConfigTo lastnameOption) {

    this.lastnameOption = lastnameOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getAdress() adress}.
   */
  public StringSearchConfigTo getAdressOption() {

    return this.adressOption;
  }

  /**
   * @param adressOption new value of {@link #getAdressOption()}.
   */
  public void setAdressOption(StringSearchConfigTo adressOption) {

    this.adressOption = adressOption;
  }

  /**
   * @return the {@link StringSearchConfigTo} used to search for {@link #getCity() city}.
   */
  public StringSearchConfigTo getCityOption() {

    return this.cityOption;
  }

  /**
   * @param cityOption new value of {@link #getCityOption()}.
   */
  public void setCityOption(StringSearchConfigTo cityOption) {

    this.cityOption = cityOption;
  }

}
