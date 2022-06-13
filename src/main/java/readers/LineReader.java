package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import entities.User;
import processors.Processor;

public class LineReader {
  public Collection<User> readLine(String filePath) {
    Map<Long, User> usersMap = new HashMap<>();
    Processor processor = new Processor(usersMap);

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        processor.getUserOrderAndProductFromLine(line);
        processor.buildingCompleteUsersMapStructure(line);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
    return usersMap.values();
  }
}