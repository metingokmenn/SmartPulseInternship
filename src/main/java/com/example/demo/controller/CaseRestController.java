package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.IntraDayTradeHistoryList;
import com.example.demo.model.Trade;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api")
public class CaseRestController {


    @Autowired
    private RestTemplate restTemplate;

    List<IntraDayTradeHistoryList> desiredData;
    List<IntraDayTradeHistoryList> allData;

    HashMap<String,ArrayList<IntraDayTradeHistoryList>> combinedData;

    

    Trade trade;
    String jsonData;

    @GetMapping("/list-trades")
    public ModelAndView convertXmlToTrade() throws Exception {

        ModelAndView mv = new ModelAndView("data-table");

        jsonData = fetchJsonDataFromUrl();
        trade = parseJsonToMap(jsonData);
        desiredData = new ArrayList<IntraDayTradeHistoryList>();

        combinedData = new HashMap<String,ArrayList<IntraDayTradeHistoryList>>();

        allData = trade.getBody().getIntraDayTradeHistoryList();

        
        eliminateConracts();

        Map<String, List<IntraDayTradeHistoryList>> tradeListGrouped =
        desiredData.stream().collect(Collectors.groupingBy(w -> w.getConract()));



        Collections.sort(desiredData, new IntraDayTradeHistoryList());

        for (List<IntraDayTradeHistoryList> tradeData : tradeListGrouped.values()) {
            double priceSum = 0;
            double quantitySum = 0;
            for (int i = 0; i < tradeData.size() ; i++) {
                priceSum += tradeData.get(i).getPrice() * tradeData.get(i).getQuantity() / 10;
                quantitySum += tradeData.get(i).getQuantity() / 10;

                tradeData.get(i).setTotalPrice(priceSum);
                tradeData.get(i).setTotalQuantity(quantitySum);
                
            }
        }

        mv.addObject("allData", tradeListGrouped);
        
        

        return mv;
    }

    private void eliminateConracts(){

        

        for (IntraDayTradeHistoryList tradeData : allData) {
            String dataConract = tradeData.getConract();
            if(dataConract.charAt(0) == 'P' && dataConract.charAt(1) == 'H'){
                desiredData.add(tradeData);
            }
            
        }
    }

    private String fetchJsonDataFromUrl() {
        String url = "https://seffaflik.epias.com.tr/transparency/service/market/intra-day-trade-history?endDate=2023-06-01&startDate=2023-06-01";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
    
    private Trade parseJsonToMap(String jsonData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, Trade.class);
    }
}
