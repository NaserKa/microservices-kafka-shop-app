package com.devonfw.bookshop.catalogservice.catalogmanagement.common.api;

import java.math.BigDecimal;
import java.time.Instant;

import com.devonfw.bookshop.catalogservice.general.common.api.ApplicationEntity;

/**
 * @author nkazimi
 */
public interface Product extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getDescription();

  public void setDescription(String description);

  public BigDecimal getPrice();

  public void setPrice(BigDecimal price);

  public Integer getQuantity();

  public void setQuantity(Integer quantity);

  public Instant getLastChange();

  public void setLastChange(Instant lastchange);

  public Integer getLastProductNumber();

  public void setLastProductNumber(Integer lastchange);

}
