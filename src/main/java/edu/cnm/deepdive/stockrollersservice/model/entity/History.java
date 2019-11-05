package edu.cnm.deepdive.stockrollersservice.model.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.lang.NonNull;

public class History {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "history_id")
  private long id;

  @NonNull
  @Column(nullable = false, updatable = false)
  private LocalDate date;

  @Column(name = "open")
  private float open;

  @Column(name = "close")
  private float close;

  @Column(name = "high")
  private float high;

  @Column(name = "low")
  private float low;

  @Column(name = "volume")
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