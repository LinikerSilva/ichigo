package processors;

import static entities.Order.extractOrderId;
import static entities.Order.formattingOrderDate;
import static entities.Product.extractProductId;
import static entities.Product.extractProductValue;

import java.math.BigDecimal;
import java.util.Set;

import entities.Order;
import entities.Product;

public class LineProcessor {
  public static Product processingProduct(String line) {
    Long productId = extractProductId(line);
    BigDecimal productValue = extractProductValue(line);
    return new Product(productId, String.valueOf(productValue));
  }

  public static Order processingOrder(String line, Set<Product> products) {
    Long orderId = extractOrderId(line);
    String orderDate = formattingOrderDate(line);
    return new Order(orderId, orderDate, String.valueOf(BigDecimal.ZERO), products);
  }
}