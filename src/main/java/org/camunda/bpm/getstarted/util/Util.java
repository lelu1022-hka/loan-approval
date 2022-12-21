package org.camunda.bpm.getstarted.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

  /**
   * Aus einem JSON Array das Credit Rating extrahieren
   * @param responseBody
   * @return Credit Rating: ["A", "B", "C"]
   */
  public static String getRating(String responseBody) {
    //ToDo Kunden mit selben Namen
    JSONArray customers = new JSONArray(responseBody);
    JSONObject customer = customers.getJSONObject(0);
    String creditrating = customer.getString("creditRating");
    return creditrating;
}
  
  /**
   * Aus einem JSON Array das Income extrahieren
   * @param responseBody
   * @return Income
   */
  public static Integer getIncome(String responseBody) {
    //ToDo Kunden mit selben Namen
    JSONArray customers = new JSONArray(responseBody);
    JSONObject album = customers.getJSONObject(0);
    Integer income = album.getInt("income");
    return income;
  }
  
  /**
   * Aus einem JSON Array den Bank Loan extrahieren
   * @param responseBody
   * @return Bank Loan
   */
  public static Integer getbankLoans(String responseBody) {
    //ToDo Kunden mit selben Namen
    JSONArray customers = new JSONArray(responseBody);
    JSONObject album = customers.getJSONObject(0);
    Integer bankLoans = album.getInt("bankLoans");
    return bankLoans;
  }
  
  /**
   * Aus einem JSON Array die ID extrahieren
   * @param responseBody
   * @return id
   */
  public static Integer getId(String responseBody) {
    //ToDo Kunden mit selben Namen
    JSONArray customers = new JSONArray(responseBody);
    JSONObject album = customers.getJSONObject(0);
    Integer id = album.getInt("id");
    return id;
  }
}
