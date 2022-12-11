package org.camunda.bpm.getstarted.entity;

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
  
  
  
}
