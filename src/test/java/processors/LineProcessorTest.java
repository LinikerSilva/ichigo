package processors;

import entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineProcessorTest {

  @Test
  void processingProductShouldReturnACorrectProductWhenLineIsValid() {
    String line = "0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909";

    Product product = LineProcessor.processingProduct(line);

    Assertions.assertEquals(3L, product.getProduct_id());
    Assertions.assertEquals("1899.02", product.getValue());
  }
}
