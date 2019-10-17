package edu.cnm.deepdive.stockrollersservice.model;

import java.awt.Point;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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

  @ManyToMany(mappedBy = "stock", fetch = FetchType.LAZY)
  private Set<Stock> share = new TreeSet<>();

  @NonNull
  private String name;

  @NonNull
  private String nasdaqName;

  @NonNull
  private String company;

  @NonNull
  private Sector sector;

  @NonNull
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

  public void setName(String name) {
    this.name = name;
  }

  public String getNasdaqName() {
    return nasdaqName;
  }

  public void setNasdaqName(String nasdaqName) {
    this.nasdaqName = nasdaqName;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Sector getSector() {
    return sector;
  }

  public void setSector(Sector sector) {
    this.sector = sector;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
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
}
