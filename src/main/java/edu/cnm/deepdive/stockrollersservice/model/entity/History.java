package edu.cnm.deepdive.stockrollersservice.model.entity;

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

@Entity
public class History {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "history_id")
  private long id;

  @NonNull
  @Column(nullable = false, updatable = false)
  private LocalDate date;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "stock_id", updatable = false, nullable = false)
  private Stock stock;

  @Column(name = "open_price")
  private float open;

  @Column(name = "close_price")
  private float close;

  @Column(name = "high_price")
  private float high;

  @Column(name = "low_price")
  private float low;

  @Column(name = "trade_volume")
  private long volume;

  public long getId() {
    return id;
  }

  @NonNull
  public LocalDate getDate() {
    return date;
  }

  public float getOpen() {
    return open;
  }

  public void setOpen(float open) {
    this.open = open;
  }

  public float getClose() {
    return close;
  }

  public void setClose(float close) {
    this.close = close;
  }

  public float getHigh() {
    return high;
  }

  public void setHigh(float high) {
    this.high = high;
  }

  public float getLow() {
    return low;
  }

  public void setLow(float low) {
    this.low = low;
  }

  public long getVolume() {
    return volume;
  }

  public void setVolume(long volume) {
    this.volume = volume;
  }
}
