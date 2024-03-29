package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.HistoryRepository;
import edu.cnm.deepdive.stockrollersservice.model.dao.StockRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import edu.cnm.deepdive.stockrollersservice.model.pojo.StockResponse;
import edu.cnm.deepdive.stockrollersservice.service.WorldTradingDataService;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryController {

  private final HistoryRepository historyRepository;
  private final StockRepository stockRepository;
  private final WorldTradingDataService tradingDataService = new WorldTradingDataService();
  private final String apiToken;

  @Autowired
  public HistoryController(@Value("${world_trading_api_key}") String apiToken, HistoryRepository historyRepository, StockRepository stockRepository) {
    this.historyRepository = historyRepository;
    this.stockRepository = stockRepository;
    this.apiToken = apiToken;
  }

  /**
   * Gets all the closing prices of a stock.
   * @param stockticker
   * @return
   */
  @GetMapping(value = "/{stockticker}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<History> get(@PathVariable String stockticker) {
    long stockId = this.stockRepository.getStockByNasdaqName(stockticker).get().getId();
    if(!this.historyRepository.getAllByStockIdOrderByDateDesc(stockId).isEmpty()) {
      LocalDate localDate = LocalDate.now();
      localDate = getClosestPreviousWeekDay(localDate);
      if (this.historyRepository.getFirstByOrderByDateDesc().get().getDate() != localDate && !localDate
          .equals(LocalDate.now())) {
        String from = this.historyRepository.getFirstByOrderByDateDesc().get().getDate().toString();
        String to = localDate.toString();
        List<History> histories =
        tradingDataService.getPostsPlainJSONHistoryByDate(apiToken, stockticker, from, to);
        histories = setStock(histories, stockId);
        this.historyRepository.saveAll(histories);
        return historyRepository.getAllByStockIdOrderByDateDesc(stockId);
      } else {
        return this.historyRepository.getAllByStockIdOrderByDateDesc(stockId);
      }
    } else {
      List<History> histories = tradingDataService.getPostsPlainJSONHistory(apiToken, stockticker);
      histories = setStock(histories, stockId);
      this.historyRepository.saveAll(histories);
      return histories;
    }
  }

  private List<History> setStock(List<History> histories, Long stockId) {
    for (History history : histories) {
      history.setStock(stockRepository.findById(stockId).get());
    }
    return histories;
  }

  private LocalDate getClosestPreviousWeekDay(LocalDate date) {
    if (date.getDayOfWeek() != DayOfWeek.SUNDAY && date.getDayOfWeek() != DayOfWeek.SATURDAY) {
      return date;
    } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
      return date.minusDays(2);
    } else {
      return date.minusDays(1);
    }
  }

  /**
   * Updates the history of a stock.
   * @param history
   * @return
   */
  @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.ACCEPTED)
  public History patch(@RequestBody History history) {
    return historyRepository.save(history);
  }

  /**
   * Deletes the history of a stock.
   * @param historyId
   */
  @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@RequestBody() long historyId) {
    historyRepository.findById(historyId).ifPresent(historyRepository::delete);
  }

  /**
   * Returns a 404 not found if a NoSuchElementException is thrown.
   */
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  /**
   * Returns a 400 bad request error.
   */
//  @ResponseStatus(HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(Exception.class)
//  public void badRequest() {
//  }

}
