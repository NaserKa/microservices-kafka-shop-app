package com.devonfw.bookshop.customerservice.customermanagement.dataaccess.api;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.devonfw.bookshop.customerservice.customermanagement.common.api.Customer;
import com.devonfw.bookshop.customerservice.general.dataaccess.api.ApplicationPersistenceEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author nkazimi
 */
@Entity
@Table(name = "Customer")
public class CustomerEntity extends ApplicationPersistenceEntity implements Customer {

  private static final long serialVersionUID = 1L;

  private String name;

  private String lastname;

  private String adress;

  private String city;

  private Instant lastChange;

  private Integer customerNumber;

  public CustomerEntity() {

    super();
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getLastname() {

    return this.lastname;
  }

  @Override
  public void setLastname(String lastnam) {

    this.lastname = lastnam;
  }

  @Override
  public String getAdress() {

    return this.adress;
  }

  @Override
  public void setAdress(String adress) {

    this.adress = adress;
  }

  @Override
  public String getCity() {

    return this.city;
  }

  @Override
  public void setCity(String city) {

    this.city = city;
  }

  @Override
  @Column(name = "lastChange", nullable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  public Instant getLastChange() {

    return this.lastChange;
  }

  @Override
  public void setLastChange(Instant lastChange) {

    this.lastChange = lastChange;
  }

  @Override
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(
          name = "sequence-generator",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
                  @Parameter(name = "sequence_name", value = "customer_sequence"),
                  @Parameter(name = "initial_value", value = "1"),
                  @Parameter(name = "increment_size", value = "1")
          }
  )
  public Integer getCustomerNumber() {

    return this.customerNumber;
  }

  @Override
  public void setCustomerNumber(Integer customerNumber) {

    this.customerNumber = customerNumber;
  }

}
