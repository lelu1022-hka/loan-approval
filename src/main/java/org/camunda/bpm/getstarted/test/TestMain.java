package org.camunda.bpm.getstarted.test;

import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.ReadService;

public class TestMain {

  public static void main(String[] args) {
    Customer customer = ReadService.getCustomerByName("Colleen", "Alford");
    
    System.out.println(customer);
  }

}
