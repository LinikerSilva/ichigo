package application;

import output.PrintAsJson;
import readers.LineReader;

public class Main {
  static LineReader lineReader = new LineReader();
  public static void main(String[] args) {
    String arg = String.valueOf(args[0]);
    lineReader.readLine(arg);
    PrintAsJson.printFileAsJson();
  }
}