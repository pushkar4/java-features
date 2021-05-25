import java.nio.file.*;

public class Main {

  public static void main(String[] args) throws Exception {

    WatchService watchService = FileSystems.getDefault().newWatchService();

    String directory = System.getProperty("user.dir") + "/java7/watch-service/src/";
    System.out.println("Browse to " + directory + " and try creating/modifying/deleting files...");

    Path watchPath = Paths.get(directory);

    watchPath.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY);

    WatchKey watchKey = watchService.take();

    boolean poll = true;
    while (poll) {
      for (WatchEvent<?> event : watchKey.pollEvents()) {
        System.out.println("Event kind: " + event.kind() + " for file: " + event.context());
      }
      poll = watchKey.reset();
    }
  }
}
