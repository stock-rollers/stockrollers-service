package edu.cnm.deepdive.stockrollersservice.model.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "UserInfo")
public class User implements Comparable<User>{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id", updatable = false, nullable = false)
  private Long id;

  //Many to many relationship for followers following or follow entity
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "follow",
      joinColumns = @JoinColumn(name = "follower_id"),
      inverseJoinColumns = @JoinColumn(name = "followed_id"))
  private Set<User> followers = new HashSet<>();

  @ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
  private Set<User> follows = new TreeSet<>();


  //Many to many relationship for user stock or stock_share entity
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "stock_share",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "stock_id"))
  private List<Stock> stocks = new LinkedList<>();

  //Many to many relationship for user industry or preferred entity
  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
      CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(name = "preferred",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "industry_id"))
  private List<User> users = new LinkedList<>();

  @NonNull
  @Column(nullable = false, updatable = false)
  private String name;

  public Long getId() {
    return id;
  }

  public Set<User> getFollowers() {
    return followers;
  }

  public Set<User> getFollows() {
    return follows;
  }

  public List<Stock> getStocks() {
    return stocks;
  }

  public List<User> getUsers() {
    return users;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(User o) {
    return 0;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
