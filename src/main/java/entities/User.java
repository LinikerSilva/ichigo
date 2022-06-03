package entities;

import java.util.HashSet;
import java.util.Set;

public class User {
  private Long user_id;
  private String name;
  private Set<Order> orders = new HashSet<>();

  public User() {
  }

  public User(Long user_id, String name, Set<Order> orders) {
    this.user_id = user_id;
    this.name = name;
    this.orders = orders;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Order> getOrders() {
    return orders;
  }

  public void addOrder(Order order) {
    this.orders.add(order);
  }
}