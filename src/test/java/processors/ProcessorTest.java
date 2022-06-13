package processors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import entities.Order;
import entities.Product;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProcessorTest {
  Processor processor = new Processor();

  String firstLine = "0000000088                             Terra Daniel DDS00000008360000000010     1899.0220210909";
  String secondLineWithAnotherDifferentUser = "0000000103                                 Gail Bradtke00000009660000000005     1564.2120210507";
  String thirdLineWithAlreadyExistentUser = "0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909";

  User terraDanielUser = new User(88L, "Terra Daniel DDS", new HashMap<>());
  Order terraDanielUserOrder = new Order(836L, "2021-09-09", String.valueOf(BigDecimal.ZERO), new HashMap<>());
  Product terraDanielUserProduct = new Product(10L, "1899.02");

  User gailBradtkeUser = new User(103L, "Gail Bradtke", new HashMap<>());
  Order gailBradtkeUserOrder = new Order(966L, "2021-05-07", String.valueOf(BigDecimal.ZERO), new HashMap<>());
  Product gailBradtkeUserProduct = new Product(5L, "1564.21");

  @Test
  void processorShouldNotReturnsANewUserIfAlreadyExistsInUsersMap() {
    processor.getUserOrderAndProductFromLine(firstLine);
    processor.buildingCompleteUsersMapStructure(firstLine);
    processor.getUserOrderAndProductFromLine(secondLineWithAnotherDifferentUser);
    processor.buildingCompleteUsersMapStructure(secondLineWithAnotherDifferentUser);
    processor.getUserOrderAndProductFromLine(thirdLineWithAlreadyExistentUser);
    processor.buildingCompleteUsersMapStructure(thirdLineWithAlreadyExistentUser);

    Map<Long, User> expectedUsersMap = new HashMap<>();
    Product newDifferentProductForExistentTerraDanielUser = new Product(3L, "1899.02");

    usersMapBuilder(terraDanielUser.userId(), terraDanielUser, terraDanielUserOrder.getOrderId(),
        terraDanielUserOrder, terraDanielUserProduct.productId(), terraDanielUserProduct, expectedUsersMap);

    usersMapBuilder(gailBradtkeUser.userId(), gailBradtkeUser, gailBradtkeUserOrder.getOrderId(),
        gailBradtkeUserOrder, gailBradtkeUserProduct.productId(), gailBradtkeUserProduct, expectedUsersMap);

    usersMapBuilder(terraDanielUser.userId(), terraDanielUser, terraDanielUserOrder.getOrderId(),
        terraDanielUserOrder, newDifferentProductForExistentTerraDanielUser.productId(), newDifferentProductForExistentTerraDanielUser, expectedUsersMap);

    Assertions.assertEquals(processor.getUsersMap().values().toString(), expectedUsersMap.values().toString());
  }

  @Test
  void processorShouldReturnsANewUserIfThisUserDoesNotExistsInUsersMap() {
    Map<Long, User> expectedUsersMap = new HashMap<>();

    processor.getUserOrderAndProductFromLine(firstLine);
    processor.buildingCompleteUsersMapStructure(firstLine);
    processor.getUserOrderAndProductFromLine(secondLineWithAnotherDifferentUser);
    processor.buildingCompleteUsersMapStructure(secondLineWithAnotherDifferentUser);

    usersMapBuilder(terraDanielUser.userId(), terraDanielUser, terraDanielUserOrder.getOrderId(),
        terraDanielUserOrder, terraDanielUserProduct.productId(), terraDanielUserProduct, expectedUsersMap);

    usersMapBuilder(gailBradtkeUser.userId(), gailBradtkeUser, gailBradtkeUserOrder.getOrderId(),
        gailBradtkeUserOrder, gailBradtkeUserProduct.productId(), gailBradtkeUserProduct, expectedUsersMap);

    Assertions.assertEquals(processor.getUsersMap().values().toString(), expectedUsersMap.values().toString());
  }

  void usersMapBuilder(Long userId, User user, Long orderId, Order order,
                       Long productId, Product product, Map<Long, User> expectedUsersMap) {
    User userObj = expectedUsersMap.getOrDefault(userId, user);
    Order orderObj = userObj.orders().getOrDefault(orderId, order);
    Product productObj = orderObj.getProducts().getOrDefault(productId, product);

    orderObj.addProductToProductsMapAndIncreasesOrderValue(productObj.productId(), productObj);
    userObj.addOrderToOrdersMap(orderObj.getOrderId(), orderObj);
    expectedUsersMap.put(userObj.userId(), userObj);
  }
}