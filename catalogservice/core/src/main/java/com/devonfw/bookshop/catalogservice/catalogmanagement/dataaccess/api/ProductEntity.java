package com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import com.devonfw.bookshop.catalogservice.catalogmanagement.common.api.Product;
import com.devonfw.bookshop.catalogservice.general.dataaccess.api.ApplicationPersistenceEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author nkazimi
 */
@Entity
@Table(name = "Product")
public class ProductEntity extends ApplicationPersistenceEntity implements Product {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private Integer quantity;

  private Instant lastChange;

  private Integer lastProductNumber;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getDescription() {

    return this.description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public BigDecimal getPrice() {

    return this.price;
  }

  @Override
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  @Override
  public Integer getQuantity() {

    return this.quantity;
  }

  @Override
  public void setQuantity(Integer quantity) {

    this.quantity = quantity;
  }

  @Override
  @Column(name = "lastChange", nullable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  public Instant getLastChange() {

    return this.lastChange;
  }

  @Override
  public void setLastChange(Instant lastchange) {

    this.lastChange = lastchange;
  }

  @Override
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(
          name = "sequence-generator",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
                  @Parameter(name = "sequence_name", value = "customer_sequence"),
                  @Parameter(name = "initial_value", value = "1"),
                  @Parameter(name = "increment_size", value = "1")
          }
  )
  public Integer getLastProductNumber() {

    return this.lastProductNumber;
  }

  @Override
  public void setLastProductNumber(Integer lastProductNumber) {

    this.lastProductNumber = lastProductNumber;
  }

}
