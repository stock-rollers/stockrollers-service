package edu.cnm.deepdive.stockrollersservice.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.view.HistoryListSerializer;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryResponse {

  private String name;

  @JsonProperty("history")
  @JsonDeserialize(using = HistoryListSerializer.Deserializer.class)
  private HistoryList historyList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HistoryList getHistoryList() {
    return historyList;
  }

  public void setHistoryList(
      HistoryList historyList) {
    this.historyList = historyList;
  }

  public static class HistoryList {

    private List<History> histories = new LinkedList<>();

    public List<History> getHistories() {
      return histories;
    }

    public void setHistories(
        List<History> histories) {
      this.histories = histories;
    }
  }
}
