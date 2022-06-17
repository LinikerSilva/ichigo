package output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.io.IOException;
import java.util.Collection;

import entities.User;

public class PrintAsJson {
  public static void printFileAsJson(Collection<User> usersMap) {
    try {
      ObjectWriter mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE).writerWithDefaultPrettyPrinter();
      mapper.writeValue(System.out, usersMap);
    } catch (IOException e) {
      System.out.println("Ocorreu um erro ao tentar exibir o arquivo Json. " + e.getMessage());
    }
  }
}