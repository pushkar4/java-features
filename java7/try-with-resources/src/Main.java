import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws Exception {
    tryBufferedReader();
    tryCustomResource();
  }

  private static void tryBufferedReader() throws IOException {
    try (BufferedReader br =
                 new BufferedReader(
                         new FileReader(
                                 System.getProperty("user.dir") + "/java7/try-with-resources/src/notes.txt"));) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } // No need of closing br in a finally block, since it is done automatically
  }

  private static void tryCustomResource() throws Exception {
    try (CustomResource resource = new CustomResource();) {
      resource.readCustomResource();
    } // No need to do a resource.close() here since it will be called automatically
  }
}
