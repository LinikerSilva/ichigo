package extractors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LineExtractors {

  public static Long extractingProductId(String line) {
    return Long.valueOf(line.substring(66, 75));
  }

  public static BigDecimal extractingProductValue(String line) {
    return new BigDecimal(line.substring(76, 87).trim());
  }

  public static Long extractingOrderId(String line) {
    return Long.valueOf(line.substring(55, 65));
  }

  public static String extractingOrderDate(String line) {
    return LocalDate.parse(line.substring(87, 95), DateTimeFormatter.ofPattern("yyyyMMdd")).toString();
  }

  public static Long extractingUserId(String line) {
    return Long.valueOf(line.substring(0, 10));
  }

  public static String extractingUserName(String line) {
    return line.substring(11, 55).trim();
  }
}