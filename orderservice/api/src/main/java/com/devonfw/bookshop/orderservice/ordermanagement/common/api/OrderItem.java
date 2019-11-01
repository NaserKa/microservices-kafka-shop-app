package com.devonfw.bookshop.orderservice.ordermanagement.common.api;

import java.math.BigDecimal;

import com.devonfw.bookshop.orderservice.general.common.api.ApplicationEntity;

/**
 * @author nkazimi
 */
public interface OrderItem extends ApplicationEntity {

  /**
   * @return nameId
   */
  public String getName();

  /**
   * @param name setter for name attribute
   */
  public void setName(String name);

  /**
   * @return priceId
   */
  public BigDecimal getPrice();

  /**
   * @param price setter for price attribute
   */
  public void setPrice(BigDecimal price);

  /**
   * @return quantityId
   */
  public Integer getQuantity();

  /**
   * @param quantity setter for quantity attribute
   */
  public void setQuantity(Integer quantity);

  /**
   * @return productIdId
   */
  public long getProductId();

  /**
   * @param productId setter for productId attribute
   */
  public void setProductId(long productId);

  /**
   * getter for orderId attribute
   *
   * @return orderId
   */
  public Long getOrderId();

  /**
   * @param order setter for order attribute
   */
  public void setOrderId(Long orderId);

}
