package edu.cnm.deepdive.stockrollersservice.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockResponse {

  private List<Stock> data = new LinkedList<>();

  public List<Stock> getData() {
    return data;
  }

  public void setData(List<Stock> data) {
    this.data = data;
  }
}
