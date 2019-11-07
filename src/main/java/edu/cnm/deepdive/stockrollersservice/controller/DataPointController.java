package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.DataPointRepository;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datapoints")
public class DataPointController {

  private final DataPointRepository dataPointRepository;

  @Autowired
  public DataPointController(DataPointRepository dataPointRepository) {
    this.dataPointRepository = dataPointRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<DataPoint> get(Stock stock) {
    return dataPointRepository.getDataPointsByStockOrderByHorizontalAsc(stock);
  }

}
