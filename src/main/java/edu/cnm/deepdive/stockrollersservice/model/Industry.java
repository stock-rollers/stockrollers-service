package edu.cnm.deepdive.stockrollersservice.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
  @JoinColumn(name = "stock_id", nullable = false, updatable = true)
  private Stock stock;

}
