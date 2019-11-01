package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.catalogservice.catalogmanagement.common.api.Product;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Product
 */
public class ProductEto extends AbstractEto implements Product {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private Integer quantity;

  private Instant lastChange;

  private Integer lastProductNumber;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getDescription() {

    return description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public BigDecimal getPrice() {

    return price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Integer getQuantity() {

    return quantity;
  }

  @Override
  public void setQuantity(Integer quantity) {

    this.quantity = quantity;
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
  public Integer getLastProductNumber() {

    return lastProductNumber;
  }

  @Override
  public void setLastProductNumber(Integer lastProductNumber) {

    this.lastProductNumber = lastProductNumber;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
    result = prime * result + ((this.lastChange == null) ? 0 : this.lastChange.hashCode());
    result = prime * result + ((this.lastProductNumber == null) ? 0 : this.lastProductNumber.hashCode());
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
    ProductEto other = (ProductEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    if (this.quantity == null) {
      if (other.quantity != null) {
        return false;
      }
    } else if (!this.quantity.equals(other.quantity)) {
      return false;
    }
    if (this.lastChange == null) {
      if (other.lastChange != null) {
        return false;
      }
    } else if (!this.lastChange.equals(other.lastChange)) {
      return false;
    }
    if (this.lastProductNumber == null) {
      if (other.lastProductNumber != null) {
        return false;
      }
    } else if (!this.lastProductNumber.equals(other.lastProductNumber)) {
      return false;
    }
    return true;
  }
}
