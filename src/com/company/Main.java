package com.company;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public final String APIKey = "A5ETHRCZN7N9TV4K";
    private final String baseURL = "https://www.alphavantage.co/query?function=%&symbol=%&interval=%min&apikey=%";

    public static void main(String[] args) {

        String APIkey = "A5ETHRCZN7N9TV4K";
        String baseURL = "https://www.alphavantage.co/query?function=%&symbol=%&interval=%min&apikey=%";

        String url = buildUrl(baseURL, "TestFunction","testSymbol", 5, APIkey);
        System.out.println(url);
    }

    /*
    Build the API request to get the INTRADAY time series
     */
    private static String buildUrl(String baseURL, String function, String symbol, int interval, String APIKey){
        String url = baseURL.replaceFirst("%", function).replaceFirst("%",symbol).replaceFirst("%",String.valueOf(interval)).replaceFirst("%",APIKey);
        return url;
    }
}
