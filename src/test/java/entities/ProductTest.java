package entities;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

  @Test
  void productEntityShouldHaveCorrectStructure() {
    Product product = new Product(1L, String.valueOf(new BigDecimal("234.55")));

    Assertions.assertEquals(1L, product.product_id());
    Assertions.assertEquals("234.55", product.value());
  }
}