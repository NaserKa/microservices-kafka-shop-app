package com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to;

import java.math.BigDecimal;

import com.devonfw.bookshop.orderservice.ordermanagement.common.api.OrderItem;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of OrderItem
 */
public class OrderItemEto extends AbstractEto implements OrderItem {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private Integer quantity;

  private long productId;

  private Long orderId;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
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
  public long getProductId() {

    return productId;
  }

  @Override
  public void setProductId(long productId) {

    this.productId = productId;
  }

  @Override
  public Long getOrderId() {

    return orderId;
  }

  @Override
  public void setOrderId(Long orderId) {

    this.orderId = orderId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.price == null) ? 0 : this.price.hashCode());
    result = prime * result + ((this.quantity == null) ? 0 : this.quantity.hashCode());
    result = prime * result + ((Long) productId).hashCode();

    result = prime * result + ((this.orderId == null) ? 0 : this.orderId.hashCode());
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
    OrderItemEto other = (OrderItemEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
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
    if (this.productId != other.productId) {
      return false;
    }

    if (this.orderId == null) {
      if (other.orderId != null) {
        return false;
      }
    } else if (!this.orderId.equals(other.orderId)) {
      return false;
    }
    return true;
  }
}
