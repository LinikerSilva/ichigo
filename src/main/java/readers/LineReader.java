package readers;

import static extractors.LineExtractors.extractingOrderDate;
import static extractors.LineExtractors.extractingOrderId;
import static extractors.LineExtractors.extractingProductId;
import static extractors.LineExtractors.extractingProductValue;
import static extractors.LineExtractors.extractingUserId;
import static extractors.LineExtractors.extractingUserName;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import entities.Order;
import entities.Product;
import entities.User;

public class LineReader {
  public void readLine(String filePath) {
    Map<Long, User> usersMap = new HashMap<>();
    Map<Long, Order> ordersMap = new HashMap<>();
    Map<Long, Product> productsMap = new HashMap<>();

    Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        Long lineUserId = extractingUserId(line);
        Long lineOrderId = extractingOrderId(line);
        Long lineProductId = extractingProductId(line);

        User user = usersMap.getOrDefault(lineUserId, new User(lineUserId, extractingUserName(line), new HashMap<>()));
        Product product = productsMap.getOrDefault(lineProductId, new Product(lineProductId, extractingProductValue(line)));
        Order order = ordersMap.getOrDefault(lineOrderId, new Order(lineOrderId, extractingOrderDate(line), String.valueOf(BigDecimal.ZERO), new HashMap<>()));

        order.addProduct(lineProductId, product);
        user.addOrder(lineOrderId, order);
        usersMap.put(lineUserId, user);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
    System.out.println(gson.toJson(usersMap));
  }
}