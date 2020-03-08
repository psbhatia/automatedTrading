package com.company;

public class Stock {
    private String symbol;
    private double price;
    private String purchaseDate;

    public Stock (String symbol, double price, String purchaseDate){
        this.symbol = symbol;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public double getPrice(){
        return this.price;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public String getPurchaseDate(){
        return this.purchaseDate;
    }

}
