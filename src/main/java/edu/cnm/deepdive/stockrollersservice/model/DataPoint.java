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
  private long stockId;

  @Nullable
  @Column(name = "x", nullable = true, updatable = false)
  private float x;

  @Nullable
  @Column(name="y", nullable = true, updatable = false)
  private LocalDate y;

  public long getId() {
    return id;
  }

  public long getStockId() {
    return stockId;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  @Nullable
  public LocalDate getY() {
    return y;
  }

  public void setY(@Nullable LocalDate y) {
    this.y = y;
  }
}
