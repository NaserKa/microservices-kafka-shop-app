package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of Product
 */
public class ProductCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private ProductEto product;

  public ProductEto getProduct() {

    return product;
  }

  public void setProduct(ProductEto product) {

    this.product = product;
  }

}
