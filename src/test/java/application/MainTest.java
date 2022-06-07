package application;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class MainTest {

  @Test
  void mainShouldNotThrowsException() {
    String[] args = new String[1];
    args[0] = "/home/liniker/Documentos/desafio-tecnico-luizalabs/arquivos-suporte/data_2 (1).txt";

    assertDoesNotThrow(() -> Main.main(args));
  }
}