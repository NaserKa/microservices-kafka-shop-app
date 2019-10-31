package com.devonfw.bookshop.customerservice.customermanagement.logic.impl.usecase;

import java.io.IOException;
import java.time.Instant;
import java.util.Objects;

import javax.inject.Named;
import com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.messaging.KafkaMessageSender;
import com.devonfw.bookshop.customerservice.customermanagement.module.kafka4devon.serializer.MessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.CustomerEntity;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase.UcManageCustomer;
import com.devonfw.bookshop.customerservice.customermanagement.logic.base.usecase.AbstractCustomerUc;

/**
 * Use case implementation for modifying and deleting Customers
 */
@Named
@Validated
@Transactional
public class UcManageCustomerImpl extends AbstractCustomerUc implements UcManageCustomer {
   /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageCustomerImpl.class);

  @Autowired
  private KafkaMessageSender kafkaMessageSender;

  @Autowired
  MessageConverter converter;


  @Override
  public boolean deleteCustomer(long customerId) {

    CustomerEntity customer = getCustomerRepository().find(customerId);
    getCustomerRepository().delete(customer);
    LOG.debug("The customer with id '{}' has been deleted.", customerId);
    return true;
  }


  @Override
  public CustomerEto saveCustomer(CustomerEto customer) {
    Objects.requireNonNull(customer, "customer");

    CustomerEntity customerEntity = getBeanMapper().map(customer, CustomerEntity.class);
    customerEntity.setLastChange(Instant.now());

    // initialize, validate customerEntity here if necessary
    CustomerEntity resultEntity = getCustomerRepository().save(customerEntity);
    LOG.debug("Customer with id '{}' has been created.", resultEntity.getId());

    // send message to Kafka Topic
    try {
      kafkaMessageSender.sendMessage(null, "customer", null, null);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return getBeanMapper().map(resultEntity, CustomerEto.class);
  }

  @Override
  public CustomerEto updateCustomer(long id, CustomerEto customer) {
    Objects.requireNonNull(customer, "customer");

    LOG.debug("Get CustomerCto with id {} from database.", id);
    CustomerEntity customerEntity = getCustomerRepository().find(id);
    customerEntity.setName(customer.getName());
    customerEntity.setLastname(customer.getLastname());
    customerEntity.setAdress(customer.getAdress());
    customerEntity.setCity(customer.getCity());

    CustomerEntity resultEntity = getCustomerRepository().save(customerEntity);
    LOG.debug("Customer with id '{}' has been updated.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, CustomerEto.class);
  }

    public void updateCustomer1(long id) {

        LOG.debug("Get CustomerCto with id {} from database.", id);
        CustomerEntity customerEntity = getCustomerRepository().find(id);
        customerEntity.setName("fdsfs");

        CustomerEntity resultEntity = getCustomerRepository().save(customerEntity);
        LOG.debug("Customer with id '{}' has been updated.", resultEntity.getId());
    }
}
