package edu.cnm.deepdive.stockrollersservice.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.springframework.lang.NonNull;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", updatable = false, nullable = false)
  private Long id;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "follow",
      joinColumns = @JoinColumn(name = "follower_id"),
      inverseJoinColumns = @JoinColumn(name = "followed_id"))
  private Set<User> followers = new TreeSet<>();

  @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
  private Set<User> follows = new TreeSet<>();

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
