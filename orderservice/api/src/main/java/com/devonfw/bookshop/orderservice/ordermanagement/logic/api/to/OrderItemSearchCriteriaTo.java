package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import java.math.BigDecimal;

import com.devonfw.bookshop.orderservice.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.bookshop.orderservice.ordermanagement.common.api.OrderItem}s.
 */
public class OrderItemSearchCriteriaTo extends AbstractSearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private Integer quantity;

  private Long productId;

  private Long orderId;

  private StringSearchConfigTo nameOption;

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
   * @return productIdId
   */

  public Long getProductId() {

    return productId;
  }

  /**
   * @param productId setter for productId attribute
   */

  public void setProductId(Long productId) {

    this.productId = productId;
  }

  /**
   * getter for orderId attribute
   * 
   * @return orderId
   */

  public Long getOrderId() {

    return orderId;
  }

  /**
   * @param order setter for order attribute
   */

  public void setOrderId(Long orderId) {

    this.orderId = orderId;
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

}
