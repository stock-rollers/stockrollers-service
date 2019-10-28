package edu.cnm.deepdive.stockrollersservice.model;

import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.lang.NonNull;

@Entity
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "stock_id", nullable = false, updatable = false)
  private long id;

  @ManyToMany(mappedBy = "stocks", fetch = FetchType.LAZY)
  private Set<User> users = new HashSet<>();

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
  @Column(nullable = false, updatable = false)
  private Sector sector;

  @NonNull
  @Column(nullable = false)
  private double price;

  private double fiftyTwoWkHigh;

  private double fiftyTwoWkLow;

  private List<Point> points;

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

  public Sector getSector() {
    return sector;
  }

  public void setSector(@NonNull Sector sector) {
    this.sector = sector;
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

  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }

  public String getPlotPath() {
    return plotPath;
  }

  public void setPlotPath(String plotPath) {
    this.plotPath = plotPath;
  }


  public enum Sector {

    FINANCIAL,
    UTILITIES,
    CONSUMER_DISCRETIONARY,
    CONSUMER_STAPLES,
    ENERGY,
    HEALTH_CARE,
    INDUSTRIAL,
    TECHNOLOGY,
    TELECOM,
    MATERIALS,
    REAL_ESTATE,


  }
}
