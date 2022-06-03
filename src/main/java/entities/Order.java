package entities;

import java.util.HashSet;
import java.util.Set;

public class Order {
  private Long order_id;
  private String date;
  private String total;
  private Set<Product> products = new HashSet<>();

  public Order() {
  }

  public Order(Long order_id, String date, String total, Set<Product> products) {
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

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }
}