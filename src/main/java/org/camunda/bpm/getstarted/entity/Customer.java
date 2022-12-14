package org.camunda.bpm.getstarted.entity;

import org.json.JSONObject;

public class Customer {

  private String prename;
  private String surname;
  private String creditRating;
  private Integer income;
  private Integer bankLoans;
  
  public Customer(String prename, String surname, String creditRating, Integer income, Integer bankLoans) {
    this.setPrename(prename);
    this.setSurname(surname);
    this.setCreditRating(creditRating);
    this.setIncome(income);
    this.setBankLoans(bankLoans);
  }

  public String getPrename() {
    return prename;
  }

  public void setPrename(String prename) {
    this.prename = prename;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getCreditRating() {
    return creditRating;
  }

  public void setCreditRating(String creditRating) {
    this.creditRating = creditRating;
  }

  public Integer getIncome() {
    return income;
  }

  public void setIncome(Integer income) {
    this.income = income;
  }

  public Integer getBankLoans() {
    return bankLoans;
  }

  public void setBankLoans(Integer bankLoans) {
    this.bankLoans = bankLoans;
  }
  
  @Override
  public String toString() {
    return (this.prename + " " + this.surname);
  }
  
  public JSONObject toJSONObject() {
    JSONObject customer = new JSONObject();
    customer.put("prename", this.prename);
    customer.put("surname", this.surname);
    customer.put("creditRating", this.creditRating);
    customer.put("income", this.income);
    customer.put("bankLoans", this.bankLoans);
    return customer;
  }
  
}
