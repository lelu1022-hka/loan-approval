package org.camunda.bpm.getstarted.ErrorHandling;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class DBTimeOut implements JavaDelegate {

  public void execute(DelegateExecution execution) throws Exception {
    execution.setVariable("dbTimeOut", false);
  }

}
