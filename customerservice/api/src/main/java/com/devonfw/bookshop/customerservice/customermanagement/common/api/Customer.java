package com.devonfw.bookshop.customerservice.customermanagement.common.api;

import java.time.Instant;

import com.devonfw.bookshop.customerservice.general.common.api.ApplicationEntity;

/**
 * @author nkazimi
 */
public interface Customer extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getLastname();

  public void setLastname(String lastname);

  public String getAdress();

  public void setAdress(String adress);

  public String getCity();

  public void setCity(String city);

  public Instant getLastChange();

  public void setLastChange(Instant lastChange);

  public Integer getCustomerNumber();

  public void setCustomerNumber(Integer customerNumber);

}
