package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.catalogservice.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.bookshop.catalogservice.catalogmanagement.common.api.Product}s.
 */
public class ProductSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String description;

  private BigDecimal price;

  private Integer quantity;

  private Instant lastChange;

  private Integer lastProductNumber;

  private StringSearchConfigTo nameOption;

  private StringSearchConfigTo descriptionOption;

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
   * @return descriptionId
   */

  public String getDescription() {

    return description;
  }

  /**
   * @param description setter for description attribute
   */

  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return priceId
   */

  public BigDecimal getPrice() {

    return price;
  }

  /**
   * @param price setter for price attribute
   */

  public void setPrice(BigDecimal price) {

    this.price = price;
  }

  /**
   * @return quantityId
   */

  public Integer getQuantity() {

    return quantity;
  }

  /**
   * @param quantity setter for quantity attribute
   */

  public void setQuantity(Integer quantity) {

    this.quantity = quantity;
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
   * @return lastProductNumberId
   */

  public Integer getLastProductNumber() {

    return lastProductNumber;
  }

  /**
   * @param lastProductNumber setter for lastProductNumber attribute
   */

  public void setLastProductNumber(Integer lastProductNumber) {

    this.lastProductNumber = lastProductNumber;
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
   * @return the {@link StringSearchConfigTo} used to search for {@link #getDescription() description}.
   */
  public StringSearchConfigTo getDescriptionOption() {

    return this.descriptionOption;
  }

  /**
   * @param descriptionOption new value of {@link #getDescriptionOption()}.
   */
  public void setDescriptionOption(StringSearchConfigTo descriptionOption) {

    this.descriptionOption = descriptionOption;
  }

}
