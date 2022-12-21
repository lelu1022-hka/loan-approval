package org.camunda.bpm.getstarted.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.camunda.bpm.getstarted.entity.Customer;
import org.camunda.bpm.getstarted.util.Util;

public class ReadService {
  
  private static final String base = "http://localhost:3000/customers";
  private static HttpURLConnection conn;
  
  /**
   * finden eines Kunden in einer JSON-Datenbank anhand von Vornamen und Nachnamen
   * @param prename Vorname des Kunden
   * @param surname Nachname des Kunden
   * @return Customer Objekt wenn gefunden sonst Null
   */
  public static Customer getCustomerByName(String prename, String surname) {
    BufferedReader reader;
    String line;
    StringBuilder responseContent = new StringBuilder();
    
    String params = "?prename=" + prename + "&?surname=" + surname;
    
    try {
      URL url = new URL(base + params);
      conn = (HttpURLConnection) url.openConnection();
     
      // Request setup
      conn.setRequestMethod("GET");
      conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
      conn.setReadTimeout(5000);
      
      // Test if the response from the server is successful
      int status = conn.getResponseCode();
      
      if (status >= 300) {
        reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        while ((line = reader.readLine()) != null) {
          responseContent.append(line);
        }
        reader.close();
      }
      else {
        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
          responseContent.append(line);
        }
        reader.close();
      }
      
      if(responseContent.length() != 2) {
        String customer = (responseContent.toString());
        String rating = Util.getRating(customer);
        Integer income = Util.getIncome(customer);
        Integer bankLoans = Util.getbankLoans(customer);
        Integer id = Util.getId(customer);
        
        return new Customer(id, prename, surname, rating, income, bankLoans);
      }
      
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      return Customer.buildErrorCustomer();
    } finally {
      conn.disconnect();
    }
    return null;
  }
  
}
