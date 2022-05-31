package readers;

import static processors.LineProcessor.processingOrderFromLine;
import static processors.LineProcessor.processingProductFromLine;
import static processors.LineProcessor.processingUserFromLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entities.Order;
import entities.Product;
import entities.User;

public class LineReader {
  public void readLine(String filePath) {
    Order order = new Order();
    User user = new User();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        Product product = processingProductFromLine(line);
        order.getProducts().add(product);
        order = processingOrderFromLine(line, order.getProducts());
        user.getOrders().add(order);
        user = processingUserFromLine(line, user.getOrders());
        order = new Order();
        user = new User();
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
  }
}