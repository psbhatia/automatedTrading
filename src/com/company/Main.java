package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public final String APIKey = "A5ETHRCZN7N9TV4K";
    private final String baseURL = "https://www.alphavantage.co/query?function=%&symbol=%&interval=%min&apikey=%";

    public static void main(String[] args) {

        String APIkey = "A5ETHRCZN7N9TV4K";
        String baseURL = "https://www.alphavantage.co/query?function=%&symbol=%&interval=%min&apikey=%";

        String urlString = buildUrl(baseURL, "TIME_SERIES_INTRADAY","AAPL", 5, APIkey);
        try {
            String response = sendGETRequest(urlString);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /*
    Build the API request to get the INTRADAY time series
     */
    private static String buildUrl(String baseURL, String function, String symbol, int interval, String APIKey){
        String url = baseURL.replaceFirst("%", function).replaceFirst("%",symbol).replaceFirst("%",String.valueOf(interval)).replaceFirst("%",APIKey);
        return url;
    }

    /*
    Make a get request to the provided URL
     */
    private static String sendGETRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
//        int responseCode = connection.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuffer content = new StringBuffer();
        String inputLine;
        while ((inputLine=in.readLine())!=null){
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

}
