package com.devonfw.bookshop.catalogservice.catalogmanagement.service.api.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.devonfw.bookshop.catalogservice.catalogmanagement.common.api.Product;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductCto;
import org.springframework.data.domain.Page;

import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.Catalogmanagement;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductEto;
import com.devonfw.bookshop.catalogservice.catalogmanagement.logic.api.to.ProductSearchCriteriaTo;

import java.util.List;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Catalogmanagement}.
 */
@Path("/catalogmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CatalogmanagementRestService {

  /**
   * Delegates to {@link Catalogmanagement#findProduct}.
   *
   * @param id the ID of the {@link ProductEto}
   * @return the {@link ProductEto}
   */
  @GET
  @Path("/product/{id}/")
  public ProductEto getProduct(@PathParam("id") long id);

  /**
   * Delegates to {@link Catalogmanagement#saveProduct}.
   *
   * @param product the {@link ProductEto} to be saved
   * @return the recently created {@link ProductEto}
   */
  @POST
  @Path("/product/")
  public ProductEto saveProduct(ProductEto product);

  /**
   * Delegates to {@link Catalogmanagement#deleteProduct}.
   *
   * @param id ID of the {@link ProductEto} to be deleted
   */
  @DELETE
  @Path("/product/{id}/")
  public void deleteProduct(@PathParam("id") long id);

  /**
   * Delegates to {@link Catalogmanagement#findProducts}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding products.
   * @return the {@link Page list} of matching {@link ProductEto}s.
   */
  @Path("/product/search")
  @POST
  public Page<ProductEto> findProducts(ProductSearchCriteriaTo searchCriteriaTo);

  /**
   * Delegates to {@link Catalogmanagement#findAllProducts}.
   *
   * @param
   * @return the {@link List ProductCto} of all entrys.
   */
  @GET
  @Path("/product/")
  public List<ProductCto> findAllProducts();

  /**
   * Delegates to {@link Catalogmanagement#updateProduct}.
   *
   * @param id,customer the {@link ProductEto} to be saved
   * @return the recently created {@link ProductEto}
   */
  @PUT
  @Path("/product/{id}")
  public ProductEto updateProduct(@PathParam("id") long id, ProductEto product);


  /**
   * Delegates to {@link Catalogmanagement#updateProduct}.
   *
   * @param id,customer the {@link ProductEto} to be saved
   * @return the recently created {@link ProductEto}
   */
  @PUT
  @Path("/product/decrease/{id}")
  public ProductEto decreaseProductQuantity(@PathParam("id") long id);

}
