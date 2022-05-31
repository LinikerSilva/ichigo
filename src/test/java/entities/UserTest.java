package entities;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void userEntityShouldHaveCorrectStructure() {
    Set<Order> orders = new HashSet<>();

    User user = new User(3L, "Rodrigo Freitas", orders);

    Assertions.assertEquals(3L, user.getUser_id());
    Assertions.assertEquals("Rodrigo Freitas", user.getName());
    Assertions.assertEquals(orders, user.getOrders());
  }
}