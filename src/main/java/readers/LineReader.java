package readers;

import static extractors.LineExtractors.extractingOrderDate;
import static extractors.LineExtractors.extractingOrderId;
import static extractors.LineExtractors.extractingUserId;
import static extractors.LineExtractors.extractingUserName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import entities.Order;
import entities.User;

public class LineReader {
  public void readLine(String filePath) {
    Map<Long, User> usersMap = new HashMap<>();
    Map<Long, Order> ordersMap = new HashMap<>();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        Long lineUserId = extractingUserId(line);
        Long lineOrderId = extractingOrderId(line);

        User user = usersMap.getOrDefault(lineUserId, new User(lineUserId, extractingUserName(line), new HashMap<>()));
        // TODO implementar lógica de getOrDefault para o Product
        Order order = ordersMap.getOrDefault(lineOrderId, new Order(lineOrderId, extractingOrderDate(line), String.valueOf(BigDecimal.ZERO), new HashSet<>()));
        user.addOrder(lineOrderId, order);
        usersMap.put(lineUserId, user);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
  }
}