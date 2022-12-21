package org.camunda.bpm.getstarted.test;

import java.net.ConnectException;

import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.ReadService;
import org.camunda.bpm.getstarted.httpclient.WriteService;
import org.camunda.bpm.getstarted.util.Util;

public class TestMain {

  public static void main(String[] args) {
    Customer customer = ReadService.getCustomerByName("Luca", "Leitzbach");
    
    System.out.println(customer.getId());
    //Customer test = new Customer(11, "Luca", "Leitzbach", "B", 100, 650);
    
    //WriteService.addNewCustomer(test);
    //WriteService.changeCustomer(test);
    
  }

}
