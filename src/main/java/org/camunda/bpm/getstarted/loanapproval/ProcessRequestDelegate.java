package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.httpclient.App;
import org.camunda.bpm.getstarted.util.Util;

public class ProcessRequestDelegate implements JavaDelegate {
  
  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  /**
   * Für einen Kundensatz in Camunda Credit Rating, Income und Bankloan zu einem gewählten Kunden setzen
   */
  public void execute(DelegateExecution execution) throws Exception {
    
    String prename = (String)execution.getVariable("prename");
    String surname = (String)execution.getVariable("surname");
    
    //ToDo Kunde nicht vorhanden
    String customer = App.getCustomerByName(prename, surname);
    
    //Utilklasse Aufruf für Parameter des Kunden
    String rating = Util.getRating(customer);
    Integer income = Util.getIncome(customer);
    Integer bankLoans = Util.getbankLoans(customer);
    
    //Setzen der Parameter im Kunden für camunda
    execution.setVariable("creditrating", rating);
    execution.setVariable("income", income);
    execution.setVariable("bankLoans", bankLoans);
    
    LOGGER.info("Processing request by '" + execution.getVariable("prename") + " " + execution.getVariable("surname") + " Rating: " + execution.getVariable("creditrating") + 
        "Income: " + execution.getVariable("income") + "Bank Loans: " + execution.getVariable("bankLoans"));
  }
}

