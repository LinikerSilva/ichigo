package application;

import java.util.Collection;

import entities.User;
import output.PrintAsJson;
import readers.LineReader;

public class Main {
  static LineReader lineReader = new LineReader();
  public static void main(String[] args) {
    String arg = String.valueOf(args[0]);
    Collection<User> usersMap = lineReader.readLine(arg);
    PrintAsJson.printFileAsJson(usersMap);
  }
}