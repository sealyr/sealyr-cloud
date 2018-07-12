package com.sealyr.framework.cloud.contract.api;

import java.util.List;

public class Page {

  private List<Customer> customers;

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }
  
}
