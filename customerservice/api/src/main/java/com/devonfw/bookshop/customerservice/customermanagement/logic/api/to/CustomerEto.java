package com.devonfw.bookshop.customerservice.customermanagement.logic.api.to;

import java.time.Instant;

import com.devonfw.bookshop.customerservice.customermanagement.common.api.Customer;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Customer
 */
public class CustomerEto extends AbstractEto implements Customer {

  private static final long serialVersionUID = 1L;

  private String name;

  private String lastname;

  private String adress;

  private String city;

  private Instant lastChange;

  private Integer customerNumber;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getLastname() {

    return lastname;
  }

  @Override
  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  @Override
  public String getAdress() {

    return adress;
  }

  @Override
  public void setAdress(String adress) {

    this.adress = adress;
  }

  @Override
  public String getCity() {

    return city;
  }

  @Override
  public void setCity(String city) {

    this.city = city;
  }

  @Override
  public Instant getLastChange() {

    return lastChange;
  }

  @Override
  public void setLastChange(Instant lastChange) {

    this.lastChange = lastChange;
  }

  @Override
  public Integer getCustomerNumber() {

    return customerNumber;
  }

  @Override
  public void setCustomerNumber(Integer customerNumber) {

    this.customerNumber = customerNumber;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.lastname == null) ? 0 : this.lastname.hashCode());
    result = prime * result + ((this.adress == null) ? 0 : this.adress.hashCode());
    result = prime * result + ((this.city == null) ? 0 : this.city.hashCode());
    result = prime * result + ((this.lastChange == null) ? 0 : this.lastChange.hashCode());
    result = prime * result + ((this.customerNumber == null) ? 0 : this.customerNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    CustomerEto other = (CustomerEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.lastname == null) {
      if (other.lastname != null) {
        return false;
      }
    } else if (!this.lastname.equals(other.lastname)) {
      return false;
    }
    if (this.adress == null) {
      if (other.adress != null) {
        return false;
      }
    } else if (!this.adress.equals(other.adress)) {
      return false;
    }
    if (this.city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!this.city.equals(other.city)) {
      return false;
    }
    if (this.lastChange == null) {
      if (other.lastChange != null) {
        return false;
      }
    } else if (!this.lastChange.equals(other.lastChange)) {
      return false;
    }
    if (this.customerNumber == null) {
      if (other.customerNumber != null) {
        return false;
      }
    } else if (!this.customerNumber.equals(other.customerNumber)) {
      return false;
    }
    return true;
  }

}
