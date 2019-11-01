package com.devonfw.bookshop.orderservice.ordermanagement.logic.impl.usecase;

import java.io.IOException;
import java.util.Objects;

import javax.inject.Named;

import com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.messaging.KafkaMessageSender;
import com.devonfw.bookshop.orderservice.ordermanagement.kafka4devon.serializer.MessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.orderservice.ordermanagement.dataaccess.api.OrderEntity;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.to.OrderEto;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.api.usecase.UcManageOrder;
import com.devonfw.bookshop.orderservice.ordermanagement.logic.base.usecase.AbstractOrderUc;

/**
 * Use case implementation for modifying and deleting Orders
 */
@Named
@Validated
@Transactional
public class UcManageOrderImpl extends AbstractOrderUc implements UcManageOrder {
  @Autowired
  private KafkaMessageSender kafkaMessageSender;

  @Autowired
  MessageConverter converter;

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageOrderImpl.class);

  @Override
  public boolean deleteOrder(long orderId) {

    OrderEntity order = getOrderRepository().find(orderId);
    getOrderRepository().delete(order);
    LOG.debug("The order with id '{}' has been deleted.", orderId);
    return true;
  }

  @Override
  public OrderEto saveOrder(OrderEto order) {

    Objects.requireNonNull(order, "order");

    OrderEntity orderEntity = getBeanMapper().map(order, OrderEntity.class);

    // initialize, validate orderEntity here if necessary
    OrderEntity resultEntity = getOrderRepository().save(orderEntity);
    LOG.debug("Order with id '{}' has been created.", resultEntity.getId());

    // send message to Kafka Topic
    try {
      kafkaMessageSender.sendMessage(resultEntity.getId(), "order_payment", null, null);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return getBeanMapper().map(resultEntity, OrderEto.class);
  }
}
