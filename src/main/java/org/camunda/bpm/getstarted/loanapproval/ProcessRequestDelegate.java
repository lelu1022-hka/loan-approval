package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.httpclient.App;

public class ProcessRequestDelegate implements JavaDelegate {
  
  private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

  public void execute(DelegateExecution execution) throws Exception {
    
    String prename = (String)execution.getVariable("prename");
    String surname = (String)execution.getVariable("surname");
    
    //ToDo Kunde nicht vorhanden
    String rating = App.getCustomerRatingByName(prename, surname);
    
    execution.setVariable("creditrating", rating);
    
    LOGGER.info("Processing request by '" + execution.getVariable("prename") + " " + execution.getVariable("surname") + " Rating: " + execution.getVariable("creditrating"));
    
    
  }
}

