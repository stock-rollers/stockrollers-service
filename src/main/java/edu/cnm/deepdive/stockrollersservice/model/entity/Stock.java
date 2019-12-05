package edu.cnm.deepdive.stockrollersservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
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
@JsonIgnoreProperties(value={}, ignoreUnknown = true, allowGetters = true)
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "stock_id", nullable = false, updatable = false)
  @JsonIgnore
  private Long id;

  @ManyToMany(mappedBy = "stocks", fetch = FetchType.LAZY)
  private List<User> users = new LinkedList<>();

  @OneToMany(mappedBy = "stock", fetch = FetchType.LAZY)
  private List<History> histories = new LinkedList<>();

  @NonNull
  @Column(nullable = false, updatable = false)
  private String nasdaqName;

  @NonNull
  @Column(nullable = false, updatable = false)
  private String company;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "industry_id")
  private Industry industry;

  @NonNull
  @Column(nullable = false)
  private Double price;

  private double fiftyTwoWkHigh;

  private double fiftyTwoWkLow;

  private String plotPath;

  public Long getId() {
    return id;
  }

  @NonNull
  public String getNasdaqName() {
    return nasdaqName;
  }

  @JsonProperty("symbol")
  public void setNasdaqName(@NonNull String nasdaqName) {
    this.nasdaqName = nasdaqName;
  }

  public String getCompany() {
    return company;
  }

  @JsonProperty("name")
  public void setCompany(@NonNull String company) {
    this.company = company;
  }

  public Industry getIndustry() {
    return industry;
  }

  public void setIndustry(Industry industry) {
    this.industry = industry;
  }

  public double getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(@NonNull Double price) {
    this.price = price;
  }

  public double getFiftyTwoWkHigh() {
    return fiftyTwoWkHigh;
  }

  @JsonProperty("52_week_high")
  public void setFiftyTwoWkHigh(double fiftyTwoWkHigh) {
    this.fiftyTwoWkHigh = fiftyTwoWkHigh;
  }

  public double getFiftyTwoWkLow() {
    return fiftyTwoWkLow;
  }

  @JsonProperty("52_week_low")
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
