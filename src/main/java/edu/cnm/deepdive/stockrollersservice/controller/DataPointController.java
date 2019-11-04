package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.DataPointRepository;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
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


}
