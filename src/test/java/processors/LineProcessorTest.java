package processors;

import java.util.HashSet;
import java.util.Set;

import entities.Order;
import entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineProcessorTest {
  String line = "0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909";

  @Test
  void processingProductShouldReturnACorrectProductWhenLineIsValid() {
    Product product = LineProcessor.processingProduct(line);

    Assertions.assertEquals(3L, product.getProduct_id());
    Assertions.assertEquals("1899.02", product.getValue());
  }

  @Test
  void processingOrderShouldReturnACorrectOrderWhenLineIsValid() {
    Set<Product> products = new HashSet<>();

    Order order = LineProcessor.processingOrder(line, products);

    Assertions.assertEquals(836L, order.getOrder_id());
    Assertions.assertEquals("2021-09-09", order.getDate());
  }
}