package readers;

import static processors.LineProcessor.processingOrder;
import static processors.LineProcessor.processingProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entities.Order;
import entities.Product;

public class LineReader {
  public void readLine(String filePath) {
    Order order = new Order();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        Product product = processingProduct(line);
        order.getProducts().add(product);
        order = processingOrder(line, order.getProducts());
        order = new Order();
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
  }
}