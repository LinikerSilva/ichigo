package entities;

import java.util.Map;

public record Order(Long order_id, String date, String total, Map<Long, Product> products) {

  public void addProduct(Long productId, Product product) {
    this.products.put(productId, product);
  }
}