package org.camunda.bpm.getstarted.httpclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.camunda.bpm.getstarted.entity.Customer;

public class WriteService {

  private static final String base = "http://localhost:3000/customers";
  private static HttpURLConnection conn;
  
  /**
   * Ein neuer Kunde wird der JSON-Datenbank hinzugefügt
   * @param customer Ein Kundenobjekt
   */
  public static void addNewCustomer(Customer customer) {
   
    try {
      URL url = new URL(base);
      conn = (HttpURLConnection)url.openConnection();
      
      // Request setup
      conn.setRequestMethod("POST");
      conn.setConnectTimeout(5000);
      conn.setReadTimeout(5000);
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);
      
      byte[] out = customer
          .toJSONObject()
          .toString()
          .getBytes(StandardCharsets.UTF_8);
      
      conn.setFixedLengthStreamingMode(out.length);
      conn.connect();
      try(OutputStream os = conn.getOutputStream()) {
        os.write(out);
      }
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
  }
  
  public static void changeCustomer(Customer customer) {
    try {
      URL url = new URL(base + "/" + customer.getId());
      conn = (HttpURLConnection)url.openConnection();
      
      // Request setup
      conn.setRequestMethod("PUT");
      conn.setConnectTimeout(5000);
      conn.setReadTimeout(5000);
      conn.setRequestProperty("Content-Type", "application/json");
      conn.setRequestProperty("Accept", "application/json");
      conn.setDoOutput(true);
      
      byte[] out = customer
          .toJSONObject()
          .toString()
          .getBytes(StandardCharsets.UTF_8);
      
      conn.setFixedLengthStreamingMode(out.length);
      conn.connect();
      try(OutputStream os = conn.getOutputStream()) {
        os.write(out);
      }
    }
    catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn.disconnect();
    }
  }
}
