package com.example.demo.model;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

public class Body {
    private List<IntraDayTradeHistoryList> intraDayTradeHistoryList;
    private List<Statistics> statistics;

    @JsonProperty("intraDayTradeHistoryList")
    public List<IntraDayTradeHistoryList> getIntraDayTradeHistoryList() { return intraDayTradeHistoryList; }
    @JsonProperty("intraDayTradeHistoryList")
    public void setIntraDayTradeHistoryList(List<IntraDayTradeHistoryList> value) { this.intraDayTradeHistoryList = value; }

    @JsonProperty("statistics")
    public List<Statistics> getStatistics() { return statistics; }
    @JsonProperty("statistics")
    public void setStatistics(List<Statistics> value) { this.statistics = value; }
}