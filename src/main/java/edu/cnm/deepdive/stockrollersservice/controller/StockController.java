package edu.cnm.deepdive.stockrollersservice.controller;

import com.google.api.client.util.Lists;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stocks")
//@Controller("/stocks")
//@ExposesResourcesFor(Stock.class)
public class StockController {

  private final StockRepository stockRepository;

  @Autowired
  public StockController(StockRepository stockRepository) {
    this.stockRepository = stockRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(Authentication auth) {
    return Lists.newArrayList(stockRepository.findAll());
  }

  @GetMapping(value = "/stocksbyuser", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> get(@RequestParam("user") long userId) {
    return stockRepository
        .getAllByUserId(userId); //Gets all stocks associated with a specific user.
  }

//  //Not sure that this is possible
//  @GetMapping(value = "stocksbyusers", produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Stock> getStockByUsers(@RequestParam("users") List<User> users) {
//    return stockRepository.getAllOrderByUsers(users);
//  }

  @GetMapping(value = "/stocksbyindustry", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Stock> getStocks(long industryId) {
    return stockRepository
        .getAllByIndustryId(industryId); //Gets all stocks from a specific industry.
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Stock addStock(@RequestBody Stock stock) {
    return stockRepository.save(stock);
  }

  @PostMapping(value = "/{id}/stock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Stock post(@RequestBody Stock stock) {
    return stockRepository.save(stock);
  }

  @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@RequestBody() long stockId) {
    stockRepository.findById(stockId).ifPresent(stockRepository::delete);
  }

  /**
   * Returns a 404 not found if a NoSuchElementException is thrown.
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Exception.class)
  public void badRequest() {
  }

}
