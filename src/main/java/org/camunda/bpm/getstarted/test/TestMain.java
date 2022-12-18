package org.camunda.bpm.getstarted.test;

import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.ReadService;
import org.camunda.bpm.getstarted.httpclient.WriteService;

public class TestMain {

  public static void main(String[] args) {
    //Customer customer = ReadService.getCustomerByName("Luca", "Leitzbach");
    
    Customer test = new Customer("Luca", "Leitzbach", "B", 100, 650);
    test.setId(12);
    
    //WriteService.addNewCustomer(test);
    WriteService.changeCustomer(test);
    
  }

}
