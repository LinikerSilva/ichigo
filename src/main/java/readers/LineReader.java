package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import processors.Processor;

public class LineReader {
  public void readLine(String filePath) {
    Processor processor = new Processor();

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        processor.getUserOrderAndProductFromLine(line);
        processor.buildingCompleteUsersMapStructure(line);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
  }
}