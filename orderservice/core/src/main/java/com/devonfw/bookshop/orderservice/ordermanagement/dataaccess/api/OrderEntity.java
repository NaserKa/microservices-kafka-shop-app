package com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devonfw.bookshop.orderservice.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.common.api.Order;

/**
 * @author nkazimi
 */
@Entity
@Table(name = "Orders")
public class OrderEntity extends ApplicationPersistenceEntity implements Order {

  private static final long serialVersionUID = 1L;

  private long customerId;

  private boolean paid;

  private BigDecimal totalPrice;

  private Instant orderDate;

  private List<OrderItemEntity> orderItems = new ArrayList<>();

  /**
   * @return orderItems
   */
  @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
  public List<OrderItemEntity> getOrderItems() {

    return this.orderItems;
  }

  /**
   * @param orderItems new value of {@link #getorderItems}.
   */
  public void setOrderItems(List<OrderItemEntity> orderItems) {

    this.orderItems = orderItems;
  }

  @Override
  public long getCustomerId() {

    return this.customerId;
  }

  @Override
  public void setCustomerId(long customerId) {

    this.customerId = customerId;
  }

  @Override
  public boolean isPaid() {

    return this.paid;
  }

  @Override
  public void setPaid(boolean paid) {

    this.paid = paid;
  }

  @Override
  public BigDecimal getTotalPrice() {

    return this.totalPrice;
  }

  @Override
  public void setTotalPrice(BigDecimal totalPrice) {

    this.totalPrice = totalPrice;
  }

  @Override
  public Instant getOrderDate() {

    return this.orderDate;
  }

  @Override
  public void setOrderDate(Instant orderDate) {

    this.orderDate = orderDate;
  }

}
