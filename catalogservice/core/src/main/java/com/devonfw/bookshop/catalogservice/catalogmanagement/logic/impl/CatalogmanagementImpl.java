package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.Catalogmanagement;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductCto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase.UcFindProduct;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase.UcManageProduct;
import com.devonfw.bookshop.catalogservice.general.logic.base.AbstractComponentFacade;

import java.util.List;

/**
 * Implementation of component interface of catalogmanagement
 */
@Named
public class CatalogmanagementImpl extends AbstractComponentFacade implements Catalogmanagement {

  @Inject
  private UcFindProduct ucFindProduct;

  @Inject
  private UcManageProduct ucManageProduct;

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.ucManageProduct.saveProduct(product);
  }

  @Override
  public ProductEto updateProduct(long id, ProductEto product) {
    return this.ucManageProduct.updateProduct(id, product);
  }

  @Override
  public ProductEto decreaseProductQuantity(long id) {
    return this.ucManageProduct.decreaseProductQuantity(id);
  }

  @Override
  public boolean deleteProduct(long id) {

    return this.ucManageProduct.deleteProduct(id);
  }

  @Override
  public ProductEto findProduct(long id) {
    return this.ucFindProduct.findProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria) {
    return this.ucFindProduct.findProducts(criteria);
  }

  @Override
  public List<ProductCto> findAllProducts() {
    return this.ucFindProduct.findAllProducts();
  }
}
