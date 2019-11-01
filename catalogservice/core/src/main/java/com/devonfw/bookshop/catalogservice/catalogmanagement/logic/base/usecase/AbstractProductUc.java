package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.bookshop.catalogservice.catalogmanagement.dataaccess.api.repo.ProductRepository;
import com.devonfw.bookshop.catalogservice.general.logic.base.AbstractUc;

/**
 * Abstract use case for Products, which provides access to the commonly necessary data access objects.
 */
public class AbstractProductUc extends AbstractUc {

  /** @see #getProductRepository() */
  @Inject
  private ProductRepository productRepository;

  /**
   * Returns the field 'productRepository'.
   * 
   * @return the {@link ProductRepository} instance.
   */
  public ProductRepository getProductRepository() {

    return this.productRepository;
  }

}
