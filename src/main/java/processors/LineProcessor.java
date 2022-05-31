package processors;

import static entities.Order.extractOrderId;
import static entities.Order.formattingOrderDate;
import static entities.Product.extractProductId;
import static entities.Product.extractProductValue;

import java.math.BigDecimal;
import java.util.Set;

import entities.Order;
import entities.Product;
import entities.User;

public class LineProcessor {
  public static Product processingProductFromLine(String line) {
    Long productId = extractProductId(line);
    BigDecimal productValue = extractProductValue(line);
    return new Product(productId, String.valueOf(productValue));
  }

  public static Order processingOrderFromLine(String line, Set<Product> products) {
    Long orderId = extractOrderId(line);
    String orderDate = formattingOrderDate(line);
    return new Order(orderId, orderDate, String.valueOf(BigDecimal.ZERO), products);
  }

  public static User processingUserFromLine(String line, Set<Order> orders) {
    Long userId = User.extractUserId(line);
    String userName = line.substring(11, 55).trim();
    return new User(userId, userName, orders);
  }


}