package org.camunda.bpm.getstarted.loanapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.httpclient.WriteService;

public class UpdateCustomer implements JavaDelegate{

	public void execute(DelegateExecution execution) throws Exception {
		
		//TODO bei Neukunde nicht ausführen
		String prename = (String)execution.getVariable("prename");
	    String surname = (String)execution.getVariable("surname");
	    String creditrating = (String)execution.getVariable("creditrating");
	    Integer income = (Integer)execution.getVariable("income");
	    Integer bankLoans = (Integer)execution.getVariable("bankLoans");
	    Integer id = (Integer)execution.getVariable("id");
		
	    Integer amount = (Integer)execution.getVariable("amount");
	    Integer interest = (Integer)execution.getVariable("interest");
	    
	    Integer newBankLoans = bankLoans + (amount * interest);
	    
	    Customer customer = new Customer(id, prename, surname, creditrating, income, newBankLoans);
	    
	    WriteService.changeCustomer(customer);
	}
}
