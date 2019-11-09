package edu.cnm.deepdive.stockrollersservice.controller;

import ch.qos.logback.core.boolex.EvaluationException;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.Industry;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
//@ExposesResourcesFor(Stock.class)
public class StockController {

  private final StockRepository stockRepository;

  @Autowired
  public StockController(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Stock> get(@RequestParam("user") long userId) {
//    return stockRepository
//        .getAllByUserId(userId); //Gets all stocks associated with a specific user.
//  } says its ambiguous

//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Stock> get(User user) {
//    return stockRepository.getAllByUsersContainingOrderByName(user);
//  } says its ambiguous

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(List<User> users) {
    return stockRepository.getAllOrderByUsers(users);
  }
//
//  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Stock> getStocks(long industryId) {
//    return stockRepository
//        .getAllByIndustryId(industryId); //Gets all stocks from a specific industry.
//  } says its ambiguous

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Stock addStock(@RequestBody Stock stock) {
    return stockRepository.save(stock);
  }

  @PostMapping(value = "{id}/stock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Stock post(@RequestBody Stock stock) {
    return stockRepository.save(stock);
  }



}
