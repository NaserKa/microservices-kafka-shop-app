package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase;

import java.util.List;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import org.springframework.data.domain.Page;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductCto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;

public interface UcFindProduct {

  /**
   * Returns a composite Product by its id 'id'.
   *
   * @param id The id 'id' of the Product.
   * @return The {@link ProductCto} with id 'id'
   */
  ProductEto findProduct(long id);

  /**
   * Returns a paginated list of composite Products matching the search criteria.
   *
   * @param criteria the {@link ProductSearchCriteriaTo}.
   * @return the {@link List} of matching {@link ProductCto}s.
   */
  Page<ProductEto> findProducts(ProductSearchCriteriaTo criteria);

  /**
   * Returns a List of all Customers.
   *
   * @param
   * @return the {@link List} of all {@link ProductCto}s.
   */
  List<ProductCto> findAllProducts();

}
