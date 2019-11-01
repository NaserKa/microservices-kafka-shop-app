package com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.usecase;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;

/**
 * Interface of UcManageProduct to centralize documentation and signatures of methods.
 */
public interface UcManageProduct {

  /**
   * Deletes a product from the database by its id 'productId'.
   *
   * @param productId Id of the product to delete
   * @return boolean <code>true</code> if the product can be deleted, <code>false</code> otherwise
   */
  boolean deleteProduct(long productId);

  /**
   * Saves a product and store it in the database.
   *
   * @param product the {@link ProductEto} to create.
   * @return the new {@link ProductEto} that has been saved with ID and version.
   */
  ProductEto saveProduct(ProductEto product);

  /**
   * Updates a product and store it in the database.
   *
   * @param product the {@link ProductEto id} to create.
   * @return the new {@link ProductEto} that has been saved with ID and version.
   */
  ProductEto updateProduct(long id, ProductEto product);

  /**
   * Updates a product and store it in the database.
   *
   * @param id the {@link ProductEto id} to create.
   * @return the new {@link ProductEto} that has been saved with ID and version.
   */
  ProductEto decreaseProductQuantity(long id);
}
