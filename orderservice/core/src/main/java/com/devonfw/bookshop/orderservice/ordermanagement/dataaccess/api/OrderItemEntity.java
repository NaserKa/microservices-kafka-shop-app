package com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.devonfw.bookshop.orderservice.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.common.api.OrderItem;

/**
 * @author nkazimi
 */
@Entity
@Table(name = "OrderItem")
public class OrderItemEntity extends ApplicationPersistenceEntity implements OrderItem {

  private static final long serialVersionUID = 1L;

  private String name;

  private BigDecimal price;

  private Integer quantity;

  private long productId;

  private OrderEntity order;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idOrder")
  public OrderEntity getOrder() {

    return this.order;
  }

  public void setOrder(OrderEntity order) {

    this.order = order;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
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
  public long getProductId() {

    return this.productId;
  }

  @Override
  public void setProductId(long productId) {

    this.productId = productId;
  }

  @Override
  @Transient
  public Long getOrderId() {

    if (this.order == null) {
      return null;
    }
    return this.order.getId();
  }

  @Override
  public void setOrderId(Long orderId) {

    if (orderId == null) {
      this.order = null;
    } else {
      OrderEntity orderEntity = new OrderEntity();
      orderEntity.setId(orderId);
      this.order = orderEntity;
    }
  }

}
