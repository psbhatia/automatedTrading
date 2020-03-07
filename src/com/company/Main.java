package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    static final String APIkey = "A5ETHRCZN7N9TV4K";
    static final String baseURL = "https://www.alphavantage.co/query?function=%&symbol=%&interval=%min&apikey=%";
    static final String function = "TIME_SERIES_INTRADAY";
    static final int interval = 5;
    static final String appleSymbol = "AAPL";

    public static void main(String[] args) {

        String urlString = buildUrl(baseURL, function,appleSymbol, interval, APIkey);
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
