package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ContractInformation implements JavaDelegate{

  private final static Logger LOGGER = Logger.getLogger("Contract");
  
  public void execute(DelegateExecution execution) throws Exception {
    
    if((boolean)execution.getVariable("approved")) {
    
      LOGGER.info("Dear Customer " + execution.getVariable("surname") + ". Your credit in the amount of " + execution.getVariable("amount") + " was approved"
          + " Your interest rate: " + execution.getVariable("interest"));
    }
    else {
      LOGGER.info("Dear Customer " + execution.getVariable("surname") + ". Your credit in the amount of " + execution.getVariable("amount") + " was not approved");
    }
  }
}