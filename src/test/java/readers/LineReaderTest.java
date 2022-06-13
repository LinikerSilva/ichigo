package readers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineReaderTest {

  private final PrintStream standardOut = System.out;
  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  public void tearDown() {
    System.setOut(standardOut);
  }

  @Test
  void readLineShouldPrintErrorMessageWhenFileIsInvalidAndDoesNotExists() {
    LineReader lineReader = new LineReader();

    lineReader.readLine("invalidPath");

    assertEquals("Ocorreu um erro durante a leitura do arquivo: invalidPath (Arquivo ou diretório inexistente)",
        outputStreamCaptor.toString().trim());
  }

  @Test
  void readLineShouldNotPrintErrorMessageWhenFileIsValidAndExists() {
    LineReader lineReader = new LineReader();

    lineReader.readLine("src/test/resources/testFile.txt");

    assertNotEquals("Ocorreu um erro durante a leitura do arquivo: invalidPath (Arquivo ou diretório inexistente)",
        outputStreamCaptor.toString().trim());
  }
}