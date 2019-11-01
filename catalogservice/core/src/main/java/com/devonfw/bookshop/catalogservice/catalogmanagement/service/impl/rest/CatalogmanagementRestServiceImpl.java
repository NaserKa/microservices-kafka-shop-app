package com.devonfw.bookshop.catalogservice.catalogmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.Catalogmanagement;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductCto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;
import com.devonfw.bookshop.catalogservice.catalogmanagement.service.api.rest.CatalogmanagementRestService;

import java.util.List;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Catalogmanagement}.
 */
@Named("CatalogmanagementRestService")
public class CatalogmanagementRestServiceImpl implements CatalogmanagementRestService {

  @Inject
  private Catalogmanagement catalogmanagement;

  @Override
  public ProductEto getProduct(long id) {

    return this.catalogmanagement.findProduct(id);
  }

  @Override
  public ProductEto saveProduct(ProductEto product) {

    return this.catalogmanagement.saveProduct(product);
  }

  @Override
  public void deleteProduct(long id) {

    this.catalogmanagement.deleteProduct(id);
  }

  @Override
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo) {

    return this.catalogmanagement.findProducts(searchCriteriaTo);
  }

  @Override
  public List<ProductCto> findAllProducts() {
    return this.catalogmanagement.findAllProducts();
  }

  @Override
  public ProductEto updateProduct(long id, ProductEto product) {
    return this.catalogmanagement.updateProduct(id, product);
  }

  @Override
  public ProductEto decreaseProductQuantity(long id) {
    return this.catalogmanagement.decreaseProductQuantity(id);
  }


}
