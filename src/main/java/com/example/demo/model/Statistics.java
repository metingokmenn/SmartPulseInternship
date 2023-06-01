package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;

public class Statistics {
    private String date;
    private double priceWeightedAverage;
    private long priceMin;
    private double priceMax;
    private long quantityMin;
    private long quantityMax;
    private long quantitySum;

    @JsonProperty("date")
    public String getDate() { return date; }
    @JsonProperty("date")
    public void setDate(String value) { this.date = value; }

    @JsonProperty("priceWeightedAverage")
    public double getPriceWeightedAverage() { return priceWeightedAverage; }
    @JsonProperty("priceWeightedAverage")
    public void setPriceWeightedAverage(double value) { this.priceWeightedAverage = value; }

    @JsonProperty("priceMin")
    public long getPriceMin() { return priceMin; }
    @JsonProperty("priceMin")
    public void setPriceMin(long value) { this.priceMin = value; }

    @JsonProperty("priceMax")
    public double getPriceMax() { return priceMax; }
    @JsonProperty("priceMax")
    public void setPriceMax(double value) { this.priceMax = value; }

    @JsonProperty("quantityMin")
    public long getQuantityMin() { return quantityMin; }
    @JsonProperty("quantityMin")
    public void setQuantityMin(long value) { this.quantityMin = value; }

    @JsonProperty("quantityMax")
    public long getQuantityMax() { return quantityMax; }
    @JsonProperty("quantityMax")
    public void setQuantityMax(long value) { this.quantityMax = value; }

    @JsonProperty("quantitySum")
    public long getQuantitySum() { return quantitySum; }
    @JsonProperty("quantitySum")
    public void setQuantitySum(long value) { this.quantitySum = value; }
}
