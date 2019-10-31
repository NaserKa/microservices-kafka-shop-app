package com.devonfw.bookshop.customerservice.customermanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api.CustomerEntity;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerCto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerEto;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.to.CustomerSearchCriteriaTo;
import com.devonfw.bookshop.customerservice.customermanagement.logic.api.usecase.UcFindCustomer;
import com.devonfw.bookshop.customerservice.customermanagement.logic.base.usecase.AbstractCustomerUc;

/**
 * Use case implementation for searching, filtering and getting Customers
 */
@Named
@Validated
@Transactional
public class UcFindCustomerImpl extends AbstractCustomerUc implements UcFindCustomer {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindCustomerImpl.class);

  @Override
  public CustomerEto findCustomer(long id) {

    LOG.debug("Get Customer with id {} from database.", id);
    Optional<CustomerEntity> foundEntity = getCustomerRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), CustomerEto.class);
    else
      return null;
  }

  @Override
  public Page<CustomerEto> findCustomers(CustomerSearchCriteriaTo criteria) {

    Page<CustomerEntity> customers = getCustomerRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(customers, CustomerEto.class);
  }

  @Override
  public CustomerCto findCustomerCto(long id) {

    LOG.debug("Get CustomerCto with id {} from database.", id);
    CustomerEntity entity = getCustomerRepository().find(id);
    CustomerCto cto = new CustomerCto();
    cto.setCustomer(getBeanMapper().map(entity, CustomerEto.class));

    return cto;
  }

  @Override
  public Page<CustomerCto> findCustomerCtos(CustomerSearchCriteriaTo criteria) {
    Page<CustomerEntity> customers = getCustomerRepository().findByCriteria(criteria);
    List<CustomerCto> ctos = new ArrayList<>();
    for (CustomerEntity entity : customers.getContent()) {
      CustomerCto cto = new CustomerCto();
      cto.setCustomer(getBeanMapper().map(entity, CustomerEto.class));
      ctos.add(cto);
    }
    Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(), criteria.getPageable().getPageSize());

    return new PageImpl<>(ctos, pagResultTo, customers.getTotalElements());
  }

  @Override
  public List<CustomerCto> findAllCustomers() {
    List<CustomerEntity> customers = getCustomerRepository().findAll();
    List<CustomerCto> ctos = new ArrayList<>();
    for (CustomerEntity entity : customers) {
      CustomerCto cto = new CustomerCto();
      cto.setCustomer(getBeanMapper().map(entity, CustomerEto.class));
      ctos.add(cto);
    }

    return ctos;
  }


}
