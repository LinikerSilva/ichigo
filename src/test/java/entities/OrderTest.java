package entities;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {
  Set<Product> products = new HashSet<>();

  @Test
  void orderEntityShouldHaveCorrectStructure() {
    Order order = new Order(111L, "2021-12-03", "2000.23", products);

    Assertions.assertEquals(111L, order.getOrder_id());
    Assertions.assertEquals("2021-12-03", order.getDate());
    Assertions.assertEquals("2000.23", order.getTotal());
    Assertions.assertEquals(products, order.getProducts());
  }
}
