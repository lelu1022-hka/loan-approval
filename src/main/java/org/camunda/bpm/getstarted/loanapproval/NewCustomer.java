package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.WriteService;

/**
 * JavaDelegate um einen neuen Kunden anzulegen
 *
 */
public class NewCustomer implements JavaDelegate {
  
  private final static Logger LOGGER = Logger.getLogger("NewCustomer");
  
  public void execute(DelegateExecution execution) throws Exception {
    
    String prename = (String)execution.getVariable("prename");
    String surname = (String)execution.getVariable("surname");
    String creditrating = (String)execution.getVariable("creditrating");
    Integer income = (Integer)execution.getVariable("income");
    Integer bankLoans = (Integer)execution.getVariable("bankLoans");
    
    Customer customer = new Customer(prename, surname, creditrating, income, bankLoans);
    
    //TODO ErrorHandling
    Customer errorCustomer = WriteService.addNewCustomer(customer);
    if (errorCustomer != null) {
      execution.setVariable("dbTimeOut", true);
      LOGGER.info("DB timedout");
      return;
    }
    
    LOGGER.info("Customer added:" + customer.toString());
  }
  
}
