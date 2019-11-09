package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.HistoryRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryController {

  private final HistoryRepository historyRepository;

  @Autowired
  public HistoryController(HistoryRepository historyRepository) {
    this.historyRepository = historyRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<History> get(Stock stock) {
    return historyRepository.getHistoriesByStock2OrderByCloseAsc(stock);
  }

}
