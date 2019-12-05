package edu.cnm.deepdive.stockrollersservice.service;

import com.google.gson.Gson;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.pojo.HistoryResponse;
import edu.cnm.deepdive.stockrollersservice.model.pojo.StockResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorldTradingDataService {

  RestTemplate restTemplate = new RestTemplateBuilder().build();

//  static WorldTradingDataService getInstance() {
//    return InstanceHolder.INSTANCE;
//  }

  public Stock getPostsPlainJSONStock(String token, String symbol) {
    try {
      Map<String, String> params = new HashMap<>();
      params.put("token", token);
      params.put("symbol", symbol);
      String url = "https://api.worldtradingdata.com/api/v1/stock?api_token={token}&symbol={symbol}";
      StockResponse response = restTemplate.getForObject(url, StockResponse.class, params);
      return response.getData().get(0);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public List<History> getPostsPlainJSONHistory(String token, String symbol) {
    try {
      List<History> histories = new LinkedList<>();
      Map<String, String> params = new HashMap<>();
      params.put("token", token);
      params.put("symbol", symbol);
      String url = "https://api.worldtradingdata.com/api/v1/history?api_token={token}&symbol={symbol}";
      HistoryResponse response = restTemplate.getForObject(url, HistoryResponse.class, params);
      return response.getHistoryList().getHistories();
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }

  public List<History> getPostsPlainJSONHistoryByDate(String token, String symbol, String from, String to) {
    try {
      List<History> histories = new LinkedList<>();
      String url = "https://api.worldtradingdata.com/api/v1/history?api_token={token}&symbol={symbol}&date_from={from}&date_to={to}";
      HistoryResponse response = restTemplate.getForObject(url, HistoryResponse.class, token, symbol, from, to);
      return response.getHistoryList().getHistories();
    } catch (Exception e) {
      throw new RuntimeException();
    }
  }
}
