package edu.cnm.deepdive.stockrollersservice.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Entity
public class DataPoint {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "data_point_id", nullable = false, updatable = false)
  private long id;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "stock_id", nullable = false, updatable = false)
  private Stock stock;

  @Nullable
  @Column(name = "vertical", nullable = true, updatable = false)
  private float vertical;

  @Nullable
  @Column(name="horizontal", nullable = true, updatable = false)
  private LocalDate horizontal;

  public long getId() {
    return id;
  }

  public Stock getStockId() {
    return stock;
  }

  public float getX() {
    return vertical;
  }

  public void setX(float vertical) {
    this.vertical = vertical;
  }

  @Nullable
  public LocalDate getY() {
    return horizontal;
  }

  public void setY(@Nullable LocalDate horizontal) {
    this.horizontal = horizontal;
  }
}
