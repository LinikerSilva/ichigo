package org.example;

import static processors.LineProcessor.processingProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Arrays.toString(args)))) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        processingProduct(line);
      }
    } catch (IOException e) {
      System.out.println("Ocorreu um erro durante a leitura do arquivo: " + e.getMessage());
    }
  }
}