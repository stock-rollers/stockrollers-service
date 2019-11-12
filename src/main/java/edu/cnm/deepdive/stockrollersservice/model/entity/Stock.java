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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.lang.NonNull;

@Entity
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "stock_id", nullable = false, updatable = false)
  private Long id;

  @ManyToMany(mappedBy = "stocks", fetch = FetchType.LAZY)
  private List<User> users = new LinkedList<>();

  @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
  private List<History> histories;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String name;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String nasdaqName;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String company;

  @NonNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "industry", nullable = false, updatable = false)
  private Industry industry;

  @NonNull
  @Column(nullable = false)
  private double price;

  private double fiftyTwoWkHigh;

  private double fiftyTwoWkLow;

  private String plotPath;

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public String getNasdaqName() {
    return nasdaqName;
  }

  public void setNasdaqName(@NonNull String nasdaqName) {
    this.nasdaqName = nasdaqName;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(@NonNull String company) {
    this.company = company;
  }

  public Industry getIndustry() {
    return industry;
  }

  public void setIndustry(@NonNull Industry industry) {
    this.industry = industry;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(@NonNull double price) {
    this.price = price;
  }

  public double getFiftyTwoWkHigh() {
    return fiftyTwoWkHigh;
  }

  public void setFiftyTwoWkHigh(double fiftyTwoWkHigh) {
    this.fiftyTwoWkHigh = fiftyTwoWkHigh;
  }

  public double getFiftyTwoWkLow() {
    return fiftyTwoWkLow;
  }

  public void setFiftyTwoWkLow(double fiftyTwoWkLow) {
    this.fiftyTwoWkLow = fiftyTwoWkLow;
  }

  public String getPlotPath() {
    return plotPath;
  }

  public void setPlotPath(String plotPath) {
    this.plotPath = plotPath;
  }

  public List<User> getUsers() {
    return users;
  }

}
