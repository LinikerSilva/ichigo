package processors;

import java.math.BigDecimal;

import entities.Product;

public class LineProcessor {

  public static Product processingProduct(String line) {
    String productId = line.substring(66, 75);
    String productValue = line.substring(76, 87).trim();
    return new Product(Long.parseLong(productId), String.valueOf(new BigDecimal(productValue)));
  }
}