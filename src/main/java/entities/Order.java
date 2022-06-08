package entities;

import java.math.BigDecimal;
import java.util.Map;

public class Order {

  Long order_id;
  String date;
  String total;
  Map<Long, Product> products;

  public Order(Long order_id, String date, String total, Map<Long, Product> products) {
    this.order_id = order_id;
    this.date = date;
    this.total = total;
    this.products = products;
  }

  public Long getOrderId() {
    return order_id;
  }

  public String getDate() {
    return date;
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

  public void addProductToProductsMapAndAddsProductValueToOrderValue(Long productId, Product product) {
    this.products.put(productId, product);
    setTotal(addProductValueToOrderValue(product));
  }

  private String addProductValueToOrderValue(Product product) {
    BigDecimal orderValue = new BigDecimal(this.total);
    return String.valueOf(orderValue.add(new BigDecimal(product.value())));
  }
}