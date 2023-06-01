package com.example.demo.model;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.*;

public class IntraDayTradeHistoryList implements Comparator<IntraDayTradeHistoryList> {
    private long id;
    private String date;
    private String conract;
    private double price;
    private long quantity;

    

    @JsonProperty("id")
    public long getId() { return id; }
    @JsonProperty("id")
    public void setId(long value) { this.id = value; }

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("conract")
    public String getConract() { return conract; }
    @JsonProperty("conract")
    public void setConract(String value) { this.conract = value; }

    @JsonProperty("price")
    public double getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(double value) { this.price = value; }

    @JsonProperty("quantity")
    public long getQuantity() { return quantity; }
    @JsonProperty("quantity")
    public void setQuantity(long value) { this.quantity = value; }

    @Override
    public String toString() {
        
        return "id: " + id + "\ndate: " + date + "\nprice: " + price + "\nquantity: " + quantity + "\n" + conract ;
    }
    

    
    @Override
    public int compare(IntraDayTradeHistoryList arg0, IntraDayTradeHistoryList arg1) {
        
        return arg0.getConract().compareTo(arg1.getConract());
    }
}