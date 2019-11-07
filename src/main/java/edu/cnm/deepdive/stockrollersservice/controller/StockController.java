package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(@RequestParam("user") long userId) {
    return stockRepository
        .getAllByUserId(userId); //Gets all stocks associated with a specific user.
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(User user) {
    return stockRepository.getAllByUsersContainingOrderByName(user);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(List<User> users) {
    return stockRepository.getAllOrderByUsers(users);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> getStocks(long industryId) {
    return stockRepository
        .getAllByIndustryId(industryId); //Gets all stocks from a specific industry.
  }

}
