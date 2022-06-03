package extractors;

import static extractors.LineExtractors.extractingOrderDate;
import static extractors.LineExtractors.extractingOrderId;
import static extractors.LineExtractors.extractingProductId;
import static extractors.LineExtractors.extractingProductValue;
import static extractors.LineExtractors.extractingUserId;
import static extractors.LineExtractors.extractingUserName;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LineExtractorsTest {
  String line = "0000000088                             Terra Daniel DDS00000008360000000003     1899.0220210909";

  @Test
  void extractingProductIdShouldReturnCorrectCurrentLineProductId() {
    Long productId = extractingProductId(line);

    Assertions.assertEquals(3L, productId);
  }

  @Test
  void extractingProductValueShouldReturnCorrectCurrentLineProductValue() {
    BigDecimal productValue = extractingProductValue(line);

    Assertions.assertEquals(new BigDecimal("1899.02"), productValue);
  }

  @Test
  void extractingOrderIdShouldReturnCorrectCurrentLineOrderId() {
    Long orderId = extractingOrderId(line);

    Assertions.assertEquals(836L, orderId);
  }

  @Test
  void extractingOrderDateShouldReturnCorrectCurrentLineOrderDate() {
    String orderDate = extractingOrderDate(line);

    Assertions.assertEquals("2021-09-09", orderDate);
  }

  @Test
  void extractingUserIdShouldReturnCorrectCurrentLineUserId() {
    Long userId = extractingUserId(line);

    Assertions.assertEquals(88L, userId);
  }

  @Test
  void extractingUserNameShouldReturnCorrectCurrentLineUserName() {
    String userName = extractingUserName(line);

    Assertions.assertEquals("Terra Daniel DDS", userName);
  }
}