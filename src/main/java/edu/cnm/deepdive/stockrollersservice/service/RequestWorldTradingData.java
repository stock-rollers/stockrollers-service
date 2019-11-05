package edu.cnm.deepdive.stockrollersservice.service;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Value;

public class RequestWorldTradingData {

  @Value("$aouth.api")
  private String token;

  private CompositeDisposable pending = new CompositeDisposable();
  private WorldTradingDataService stockService = WorldTradingDataService.getInstance();
  private ExecutorService executor;

  private long stockId;

  public void createStock() { //TODO DO NOT SEND WITH API KEY
    pending.add(
        stockService.getStock(token, "FB")
        .subscribeOn(Schedulers.from(executor))
        .subscribe((stock) -> {
        })
    );
  }

  public void createHistory() {

  }

}
