package entities;

import java.math.BigDecimal;

public class Product {
  private Long product_id;
  private String value;

  public Product() {
  }

  public Product(Long product_id, String value) {
    this.product_id = product_id;
    this.value = value;
  }

  public Long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(Long product_id) {
    this.product_id = product_id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public static Long extractProductId(String line) {
    return Long.valueOf(line.substring(66, 75));
  }

  public static BigDecimal extractProductValue(String line) {
    return new BigDecimal(line.substring(76, 87).trim());
  }
}