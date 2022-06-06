package entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
  private Long order_id;
  private String date;
  private String total;
  private Map<Long, Product> products = new HashMap<>();

  public Order() {
  }

  public Order(Long order_id, String date, String total, Map<Long, Product> products) {
    this.order_id = order_id;
    this.date = date;
    this.total = total;
    this.products = products;
  }

  public Order orderBuilder() {
    return new Order();
  }

  public Long getOrder_id() {
    return order_id;
  }

  public void setOrder_id(Long order_id) {
    this.order_id = order_id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public Map<Long, Product> getProducts() {
    return products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(order_id, order.order_id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(order_id);
  }

  public void addProduct(Long productId, Product product) {
    this.products.put(productId, product);
  }
}