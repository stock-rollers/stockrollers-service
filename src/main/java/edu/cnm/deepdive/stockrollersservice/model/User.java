package edu.cnm.deepdive.stockrollersservice.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", updatable = false, nullable = false)
  private Long id;

  @NonNull
  @Column(nullable = false, updatable = false)
  private List<Stock> favorites;

  @NonNull
  @Column(name = "preferred", nullable = false, updatable = false)
  List<Sector> preferred;

  @NonNull
  @Column(name = "stock_name", nullable = false, updatable = false)
  private String stockName;

  public List<Stock> getFavorites() {
    return favorites;
  }

  public void setFavorites(List<Stock> favorites) {
    this.favorites = favorites;
  }

  public List<Sector> getPreferred() {
    return preferred;
  }

  public void setPreferred(List<Sector> preferred) {
    this.preferred = preferred;
  }

  public String getStockName() {
    return stockName;
  }

  public void setStockName(String stockName) {
    this.stockName = stockName;
  }
}
