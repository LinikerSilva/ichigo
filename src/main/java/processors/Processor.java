package processors;

import static extractors.LineExtractors.extractingOrderDate;
import static extractors.LineExtractors.extractingOrderId;
import static extractors.LineExtractors.extractingProductId;
import static extractors.LineExtractors.extractingProductValue;
import static extractors.LineExtractors.extractingUserId;
import static extractors.LineExtractors.extractingUserName;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import entities.Order;
import entities.Product;
import entities.User;

public class Processor {
  private Order order;
  private Product product;
  private User user;
  private final Map<Long, User> usersMap;

  public Processor(Map<Long, User> usersMap) {
    this.usersMap = usersMap;
  }

  public void getUserOrderAndProductFromLine(String line) {
    Long currentLineUserId = extractingUserId(line);
    Long currentLineOrderId = extractingOrderId(line);
    Long currentLineProductId = extractingProductId(line);

    setUser(usersMap.getOrDefault(currentLineUserId, new User(currentLineUserId, extractingUserName(line), new HashMap<>())));
    setOrder(user.orders().getOrDefault(currentLineOrderId, new Order(currentLineOrderId, extractingOrderDate(line), String.valueOf(BigDecimal.ZERO), new HashMap<>())));
    setProduct(order.getProducts().getOrDefault(currentLineProductId, new Product(currentLineProductId, extractingProductValue(line))));
  }

  public void buildingCompleteUsersMapStructure(String line) {
    order.addProductToProductsMapAndIncreasesOrderValue(extractingProductId(line), product);
    user.addOrderToOrdersMap(extractingOrderId(line), order);
    addUserToUsersMap(extractingUserId(line), user);
  }

  public Map<Long, User> getUsersMap() {
    return usersMap;
  }

  private void setOrder(Order order) {
    this.order = order;
  }

  private void setProduct(Product product) {
    this.product = product;
  }

  private void setUser(User user) {
    this.user = user;
  }

  private void addUserToUsersMap(Long userId, User user) {
    usersMap.put(userId, user);
  }
}