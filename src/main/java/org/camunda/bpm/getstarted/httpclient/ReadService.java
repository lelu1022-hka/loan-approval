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
  
  public static final String base = "http://localhost:3000/customers";
  private static HttpURLConnection conn;
  
  /**
   * fidnen eines Kunden anhand von Vornamen und Nachnamen
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
      String customer = (responseContent.toString());
      String rating = Util.getRating(customer);
      Integer income = Util.getIncome(customer);
      Integer bankLoans = Util.getbankLoans(customer);
      
      return new Customer(prename, surname, rating, income, bankLoans);
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
    return null;
  }
  
}
