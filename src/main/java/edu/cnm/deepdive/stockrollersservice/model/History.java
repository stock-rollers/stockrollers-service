package edu.cnm.deepdive.stockrollersservice.model;

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

}
