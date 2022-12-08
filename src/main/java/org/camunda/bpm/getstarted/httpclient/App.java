package org.camunda.bpm.getstarted.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class App{
    
    private static HttpURLConnection conn;
   
    private static String parse(String responseBody) {
      //ToDo Kunden mit selben Namen
      JSONArray customers = new JSONArray(responseBody);
      JSONObject album = customers.getJSONObject(0); 
      String creditrating = album.getString("creditRating");
      return creditrating;
  }
    
    
    public static String getCustomerRatingByName(String prename, String surname) {
        
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        String base = "http://localhost:3000/customers";
        String params = "?prename=" + prename + "&?surname=" + surname;
        String rating = "";
        try{
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
            //System.out.println(responseContent.toString());
            rating = parse(responseContent.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            conn.disconnect();
        }
        return rating;
    }
    
    /**
    public static void main(String[] args) {
      String rating = getCustomerRatingByName("Callie", "Oliver");
      System.out.println(rating);
    }
    **/

}
