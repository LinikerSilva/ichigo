package entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

public record User(Long userId, String name, @JsonSerialize(using = HashMapSerializer.class) Map<Long, Order> orders) {

  public void addOrderToOrdersMap(Long orderId, Order order) {
    this.orders.put(orderId, order);
  }
}