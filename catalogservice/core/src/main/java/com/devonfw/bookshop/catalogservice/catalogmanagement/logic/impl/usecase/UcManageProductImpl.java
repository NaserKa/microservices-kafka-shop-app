package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api.ProductEntity;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase.UcManageProduct;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.base.usecase.AbstractProductUc;

/**
 * Use case implementation for modifying and deleting Products
 */
@Named
@Validated
@Transactional
public class UcManageProductImpl extends AbstractProductUc implements UcManageProduct {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageProductImpl.class);

  @Override
  public boolean deleteProduct(long productId) {

    ProductEntity product = getProductRepository().find(productId);
    getProductRepository().delete(product);
    LOG.debug("The product with id '{}' has been deleted.", productId);
    return true;
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    Objects.requireNonNull(product, "product");

    ProductEntity productEntity = getBeanMapper().map(product, ProductEntity.class);

    // initialize, validate productEntity here if necessary
    ProductEntity resultEntity = getProductRepository().save(productEntity);
    LOG.debug("Product with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, ProductEto.class);
  }

  @Override
  public ProductEto updateProduct(long id, ProductEto product) {
    Objects.requireNonNull(product, "customer");

    LOG.debug("Get Product with id {} from database.", id);
    ProductEntity productEntity = getProductRepository().find(id);
    productEntity.setName(product.getName());
    productEntity.setDescription(product.getDescription());
    productEntity.setPrice(product.getPrice());
    productEntity.setQuantity(product.getQuantity());

    ProductEntity resultEntity = getProductRepository().save(productEntity);
    LOG.debug("Product with id '{}' has been updated.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, ProductEto.class);
  }

  @Override
  public ProductEto decreaseProductQuantity(long id) {
    LOG.debug("Get Product with id {} from database.", id);
    ProductEntity productEntity = getProductRepository().find(id);
    if(productEntity.getQuantity() > 1) {
      productEntity.setQuantity(productEntity.getQuantity() - 1);
    } else {
      LOG.info("");
    }
    ProductEntity resultEntity = getProductRepository().save(productEntity);
    LOG.debug("Quantity of Product with id '{}' has been updated.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, ProductEto.class);
  }
}
