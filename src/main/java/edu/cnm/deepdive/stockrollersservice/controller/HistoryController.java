package edu.cnm.deepdive.stockrollersservice.controller;

import edu.cnm.deepdive.stockrollersservice.model.dao.HistoryRepository;
import edu.cnm.deepdive.stockrollersservice.model.entity.DataPoint;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.entity.Stock;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryController {

  private final HistoryRepository historyRepository;

  @Autowired
  public HistoryController(HistoryRepository historyRepository) {
    this.historyRepository = historyRepository;
  }

  /**
   * Gets all the closing prices of a stock.
   * @param stock
   * @return
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<History> get(Stock stock) {
    return historyRepository.getHistoriesByStock2OrderByCloseAsc(stock);
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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Exception.class)
  public void badRequest() {
  }

}
