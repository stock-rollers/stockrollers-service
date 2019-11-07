package edu.cnm.deepdive.stockrollersservice.model.entity;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.lang.NonNull;

@Entity
public class Industry {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "industry_id", nullable = false, updatable = false)
  private long id;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String name;

  @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
  private List<Industry> industries = new LinkedList<>();

  @NonNull
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "stock_id", nullable = false, updatable = false)
  private List<Stock> stocks;

  public long getId() {
    return id;
  }

  public List<Industry> getIndustries() {
    return industries;
  }

  public List<Stock> getStocks() {
    return stocks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
