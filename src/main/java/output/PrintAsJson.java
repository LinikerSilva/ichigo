package output;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;

import entities.User;

public class PrintAsJson {
  public static void printFileAsJson(Collection<User> usersMap) {
     Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .disableHtmlEscaping().setPrettyPrinting().create();

    System.out.println(gson.toJson(usersMap));
  }
}