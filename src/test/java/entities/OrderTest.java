package entities;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {
  @Test
  void orderShouldCorrectlyAddProductToProductsMapAndIncreasesOrderValue() {
    Order order = new Order(111L, "2021-12-03", String.valueOf(BigDecimal.ZERO), new HashMap<>());
    Product firstProduct = new Product(3L, "345.00");
    Product secondProduct = new Product(2L, "100.00");

    order.addProductToProductsMapAndIncreasesOrderValue(firstProduct.productId(), firstProduct);
    order.addProductToProductsMapAndIncreasesOrderValue(secondProduct.productId(), secondProduct);

    Assertions.assertEquals(3L, order.getProducts().get(3L).productId());
    Assertions.assertEquals(2L, order.getProducts().get(2L).productId());
    Assertions.assertEquals("345.00", order.getProducts().get(3L).value());
    Assertions.assertEquals("100.00", order.getProducts().get(2L).value());
    Assertions.assertEquals("445.00", order.getTotal());
  }
}