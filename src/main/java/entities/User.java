package entities;

import java.util.Map;

public record User(Long user_id, String name, Map<Long, Order> orders) {

  public void addOrderToOrdersMap(Long orderId, Order order) {
    this.orders.put(orderId, order);
  }
}