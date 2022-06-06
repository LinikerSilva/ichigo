package entities;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {
  Map<Long, Product> products = new HashMap<>();

  @Test
  void orderEntityShouldHaveCorrectStructure() {
    Order order = new Order(111L, "2021-12-03", "2000.23", products);

    Assertions.assertEquals(111L, order.getOrder_id());
    Assertions.assertEquals("2021-12-03", order.getDate());
    Assertions.assertEquals("2000.23", order.getTotal());
    Assertions.assertEquals(products, order.getProducts());
  }
}
