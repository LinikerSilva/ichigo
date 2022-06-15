package processors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import entities.Order;
import entities.Product;
import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessorTest {
  String firstLine;
  String secondLineWithAnotherDifferentUser;
  String thirdLineWithAlreadyExistentUser;
  User terraDanielUser;
  Order terraDanielUserOrder;
  Product terraDanielUserProduct;
  User gailBradtkeUser;
  Order gailBradtkeUserOrder;
  Product gailBradtkeUserProduct;
  Processor processor;

  @BeforeEach
  void setUp() {
    firstLine = "0000000088                             Terra Daniel DDS00000008360000000010     1899.0220210909";
    secondLineWithAnotherDifferentUser = "0000000103                                 Gail Bradtke00000009660000000005     1564.2120210507";
    thirdLineWithAlreadyExistentUser = "0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909";

    terraDanielUser = new User(88L, "Terra Daniel DDS", new HashMap<>());
    terraDanielUserOrder = new Order(836L, "2021-09-09", String.valueOf(BigDecimal.ZERO), new HashMap<>());
    terraDanielUserProduct = new Product(10L, "1899.02");

    gailBradtkeUser = new User(103L, "Gail Bradtke", new HashMap<>());
    gailBradtkeUserOrder = new Order(966L, "2021-05-07", String.valueOf(BigDecimal.ZERO), new HashMap<>());
    gailBradtkeUserProduct = new Product(5L, "1564.21");
    processor = new Processor(new HashMap<>());
  }

  @Test
  void processorShouldNotReturnsANewUserIfAlreadyExistsInUsersMap() {
    Map<Long, User> expectedUsersMap = new HashMap<>();
    Product newDifferentProductForExistentTerraDanielUser = new Product(3L, "1899.02");

    executeProcessor();
    processor.getUserOrderAndProductFromLine(thirdLineWithAlreadyExistentUser);
    processor.buildingCompleteUsersMapStructure(thirdLineWithAlreadyExistentUser);

    User terraDanielUserInProcessorUsersMap = processor.getUsersMap().get(terraDanielUser.userId());
    User gailBradtkeUserInProcessorUsersMap = processor.getUsersMap().get(gailBradtkeUser.userId());
    Order terraDanielOrderInProcessorUsersMap = terraDanielUserInProcessorUsersMap.orders().get(terraDanielUserOrder.getOrderId());
    Order gailBradtkeOrderInProcessorUsersMap = gailBradtkeUserInProcessorUsersMap.orders().get(gailBradtkeUserOrder.getOrderId());
    Product terraDanielProduct10InProcessorUsersMap = terraDanielOrderInProcessorUsersMap.getProducts().get(terraDanielUserProduct.productId());
    Product gailBradtkeProductInProcessorUsersMap = gailBradtkeOrderInProcessorUsersMap.getProducts().get(gailBradtkeUserProduct.productId());
    Product terraDanielProduct3InProcessorUsersMap = terraDanielOrderInProcessorUsersMap.getProducts().get(newDifferentProductForExistentTerraDanielUser.productId());

    buildExpectedUsersMap(expectedUsersMap);

    usersMapBuilder(terraDanielUser.userId(), terraDanielUser, terraDanielUserOrder.getOrderId(),
        terraDanielUserOrder, newDifferentProductForExistentTerraDanielUser.productId(), newDifferentProductForExistentTerraDanielUser, expectedUsersMap);

    User terraDanielUserInExpectedUsersMap = expectedUsersMap.get(terraDanielUser.userId());
    User gailBradtkeUserInExpectedUsersMap = expectedUsersMap.get(gailBradtkeUser.userId());
    Order terraDanielOrderInExpectedUsersMap = terraDanielUserInProcessorUsersMap.orders().get(terraDanielUserOrder.getOrderId());
    Order gailBradtkeOrderInExpectedUsersMap = gailBradtkeUserInProcessorUsersMap.orders().get(gailBradtkeUserOrder.getOrderId());
    Product terraDanielProduct10InExpectedUsersMap = terraDanielOrderInProcessorUsersMap.getProducts().get(terraDanielUserProduct.productId());
    Product gailBradtkeProductInExpectedUsersMap = gailBradtkeOrderInProcessorUsersMap.getProducts().get(gailBradtkeUserProduct.productId());
    Product terraDanielProduct3InExpectedUsersMap = terraDanielOrderInExpectedUsersMap.getProducts().get(newDifferentProductForExistentTerraDanielUser.productId());

    Assertions.assertEquals(terraDanielUserInProcessorUsersMap.toString(), terraDanielUserInExpectedUsersMap.toString());
    Assertions.assertEquals(gailBradtkeUserInProcessorUsersMap.toString(), gailBradtkeUserInExpectedUsersMap.toString());
    Assertions.assertEquals(terraDanielOrderInProcessorUsersMap.toString(), terraDanielOrderInExpectedUsersMap.toString());
    Assertions.assertEquals(gailBradtkeOrderInProcessorUsersMap.toString(), gailBradtkeOrderInExpectedUsersMap.toString());
    Assertions.assertEquals(terraDanielProduct10InProcessorUsersMap, terraDanielProduct10InExpectedUsersMap);
    Assertions.assertEquals(gailBradtkeProductInProcessorUsersMap, gailBradtkeProductInExpectedUsersMap);
    Assertions.assertEquals(terraDanielProduct3InProcessorUsersMap, terraDanielProduct3InExpectedUsersMap);
  }

  @Test
  void processorShouldReturnsANewUserIfThisUserDoesNotExistsInUsersMap() {
    Map<Long, User> expectedUsersMap = new HashMap<>();

    executeProcessor();

    User terraDanielUserInProcessorUsersMap = processor.getUsersMap().get(terraDanielUser.userId());
    User gailBradtkeUserInProcessorUsersMap = processor.getUsersMap().get(gailBradtkeUser.userId());
    Order terraDanielOrderInProcessorUsersMap = terraDanielUserInProcessorUsersMap.orders().get(terraDanielUserOrder.getOrderId());
    Order gailBradtkeOrderInProcessorUsersMap = gailBradtkeUserInProcessorUsersMap.orders().get(gailBradtkeUserOrder.getOrderId());
    Product terraDanielProduct10InProcessorUsersMap = terraDanielOrderInProcessorUsersMap.getProducts().get(terraDanielUserProduct.productId());
    Product gailBradtkeProductInProcessorUsersMap = gailBradtkeOrderInProcessorUsersMap.getProducts().get(gailBradtkeUserProduct.productId());

    buildExpectedUsersMap(expectedUsersMap);

    User terraDanielUserInExpectedUsersMap = expectedUsersMap.get(terraDanielUser.userId());
    User gailBradtkeUserInExpectedUsersMap = expectedUsersMap.get(gailBradtkeUser.userId());
    Order terraDanielOrderInExpectedUsersMap = terraDanielUserInProcessorUsersMap.orders().get(terraDanielUserOrder.getOrderId());
    Order gailBradtkeOrderInExpectedUsersMap = gailBradtkeUserInProcessorUsersMap.orders().get(gailBradtkeUserOrder.getOrderId());
    Product terraDanielProduct10InExpectedUsersMap = terraDanielOrderInProcessorUsersMap.getProducts().get(terraDanielUserProduct.productId());
    Product gailBradtkeProductInExpectedUsersMap = gailBradtkeOrderInProcessorUsersMap.getProducts().get(gailBradtkeUserProduct.productId());

    Assertions.assertEquals(terraDanielUserInProcessorUsersMap.toString(), terraDanielUserInExpectedUsersMap.toString());
    Assertions.assertEquals(gailBradtkeUserInProcessorUsersMap.toString(), gailBradtkeUserInExpectedUsersMap.toString());
    Assertions.assertEquals(terraDanielOrderInProcessorUsersMap.toString(), terraDanielOrderInExpectedUsersMap.toString());
    Assertions.assertEquals(gailBradtkeOrderInProcessorUsersMap.toString(), gailBradtkeOrderInExpectedUsersMap.toString());
    Assertions.assertEquals(terraDanielProduct10InProcessorUsersMap, terraDanielProduct10InExpectedUsersMap);
    Assertions.assertEquals(gailBradtkeProductInProcessorUsersMap, gailBradtkeProductInExpectedUsersMap);
  }

  private void executeProcessor() {
    processor.getUserOrderAndProductFromLine(firstLine);
    processor.buildingCompleteUsersMapStructure(firstLine);
    processor.getUserOrderAndProductFromLine(secondLineWithAnotherDifferentUser);
    processor.buildingCompleteUsersMapStructure(secondLineWithAnotherDifferentUser);
  }

  private void buildExpectedUsersMap(Map<Long, User> expectedUsersMap) {
    usersMapBuilder(terraDanielUser.userId(), terraDanielUser, terraDanielUserOrder.getOrderId(),
        terraDanielUserOrder, terraDanielUserProduct.productId(), terraDanielUserProduct, expectedUsersMap);

    usersMapBuilder(gailBradtkeUser.userId(), gailBradtkeUser, gailBradtkeUserOrder.getOrderId(),
        gailBradtkeUserOrder, gailBradtkeUserProduct.productId(), gailBradtkeUserProduct, expectedUsersMap);
  }

  private void usersMapBuilder(Long userId, User user, Long orderId, Order order,
                       Long productId, Product product, Map<Long, User> expectedUsersMap) {
    User userObj = expectedUsersMap.getOrDefault(userId, user);
    Order orderObj = userObj.orders().getOrDefault(orderId, order);
    Product productObj = orderObj.getProducts().getOrDefault(productId, product);

    orderObj.addProductToProductsMapAndIncreasesOrderValue(productObj.productId(), productObj);
    userObj.addOrderToOrdersMap(orderObj.getOrderId(), orderObj);
    expectedUsersMap.put(userObj.userId(), userObj);
  }
}