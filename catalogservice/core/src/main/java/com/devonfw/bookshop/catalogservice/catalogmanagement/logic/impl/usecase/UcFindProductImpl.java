package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.impl.usecase;

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

import com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api.ProductEntity;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductCto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase.UcFindProduct;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for searching, filtering and getting Products
 */
@Named
@Validated
@Transactional
public class UcFindProductImpl extends AbstractProductUc implements UcFindProduct {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindProductImpl.class);

  @Override
  public ProductEto findProduct(long id) {

    LOG.debug("Get Product with id {} from database.", id);
    Optional<ProductEntity> foundEntity = getProductRepository().findById(id);
    if (foundEntity.isPresent())
      return getBeanMapper().map(foundEntity.get(), ProductEto.class);
    else
      return null;
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {

    Page<ProductEntity> products = getProductRepository().findByCriteria(criteria);
    return mapPaginatedEntityList(products, ProductEto.class);
  }

  @Override
  public List<ProductCto> findAllProducts() {
    List<ProductEntity> products = getProductRepository().findAll();
    List<ProductCto> ctos = new ArrayList<>();
    for (ProductEntity entity : products) {
      ProductCto cto = new ProductCto();
      cto.setProduct(getBeanMapper().map(entity, ProductEto.class));
      ctos.add(cto);
    }

    return ctos;
  }

}
