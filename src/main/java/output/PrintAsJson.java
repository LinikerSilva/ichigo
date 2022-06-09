package output;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import processors.Processor;

public class PrintAsJson {
  public static void printFileAsJson() {
     Processor processor = new Processor();
     Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .disableHtmlEscaping().setPrettyPrinting().create();

    System.out.println(gson.toJson(processor.getUsersMap().values()));
  }
}