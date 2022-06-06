package entities;

import java.util.HashMap;
import java.util.Map;

public class User {
  private Long user_id;
  private String name;
  private Map<Long, Order> orders = new HashMap<>();

  public User() {
  }

  public User(Long user_id, String name, Map<Long, Order> orders) {
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

  public Map<Long, Order> getOrders() {
    return orders;
  }

  public void addOrder(Long orderId, Order order) {
    this.orders.put(orderId, order);
  }
}