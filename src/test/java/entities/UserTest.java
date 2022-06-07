package entities;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void userEntityShouldHaveCorrectStructure() {
    Map<Long, Order> orders = new HashMap<>();

    User user = new User(3L, "Rodrigo Freitas", orders);

    Assertions.assertEquals(3L, user.user_id());
    Assertions.assertEquals("Rodrigo Freitas", user.name());
    Assertions.assertEquals(orders, user.orders());
  }
}