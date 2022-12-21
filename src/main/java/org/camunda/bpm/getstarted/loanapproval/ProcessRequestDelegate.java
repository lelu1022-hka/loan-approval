package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.ReadService;

public class ProcessRequestDelegate implements JavaDelegate {
  
  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  /**
   * Für einen Kundensatz in Camunda Credit Rating, Income und Bankloan zu einem gewählten Kunden setzen
   */
  public void execute(DelegateExecution execution) throws Exception {
    
    String prename = (String)execution.getVariable("prename");
    String surname = (String)execution.getVariable("surname");
    
    Customer customer = ReadService.getCustomerByName(prename, surname);
    
    if (customer != null) {
    execution.setVariable("creditrating", customer.getCreditRating());
    execution.setVariable("income", customer.getIncome());
    execution.setVariable("bankLoans", customer.getBankLoans());
    execution.setVariable("foundCustomer", true);
    execution.setVariable("id", customer.getId());
    
    LOGGER.info("Processing request by '" + execution.getVariable("prename") + " " + execution.getVariable("surname") + 
        " Rating: " + execution.getVariable("creditrating") + 
        "Income: " + execution.getVariable("income") + "Bank Loans: " + execution.getVariable("bankLoans"));
    }
    else {
      //boolean found = false;
      execution.setVariable("foundCustomer", false);
      LOGGER.info("Customer not found");
    }
  }
}

