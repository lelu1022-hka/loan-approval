package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.WriteService;

public class NewCustomer implements JavaDelegate {
  
  private final static Logger LOGGER = Logger.getLogger("NewCustomer");
  
  public void execute(DelegateExecution execution) throws Exception {
    
    String prename = (String)execution.getVariable("prename");
    String surname = (String)execution.getVariable("surname");
    String creditrating = (String)execution.getVariable("creditrating");
    Integer income = (Integer)execution.getVariable("income");
    Integer bankLoans = (Integer)execution.getVariable("bankLoans");
    
    Customer customer = new Customer(prename, surname, creditrating, income, bankLoans);
    
    WriteService.addNewCustomer(customer);
    
    LOGGER.info("Customer added:" + customer.toString());
  }
  
}