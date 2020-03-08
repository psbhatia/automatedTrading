package com.company;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Stock> currentlyHeld;
    private double currentValue;

    public Portfolio(double value){
        this.currentlyHeld = new ArrayList<Stock>();
        this.currentValue = value;
    }

    /*
    Purchase a stock and add to this portfolio
     */
    public void purchaseStock(Stock stock){
        this.currentValue = this.currentValue - stock.getPrice();
        this.currentlyHeld.add(stock);
    }

    /*
    Sell the stock, take out of poryfolio and add the selling price
     */
    public void sellStock(Stock stock, double sellingPrice){
        this.currentlyHeld.remove(stock);
        this.currentValue = this.currentValue + sellingPrice;
    }

    public double getCurrentValue(){
        return this.currentValue;
    }

}
