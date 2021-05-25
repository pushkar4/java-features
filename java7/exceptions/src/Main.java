public class Main {

  public static void main(String[] args) {
    suppressedExceptionsDemo();
    catchMultipleExceptionsDemo();
  }

  private static void suppressedExceptionsDemo() {
    try {
      accessDirtyResource();
    } catch (Exception e) {
      System.out.println("Original exception: " + e.getMessage());

      // Let's get the exception which might have occurred after we hit our first exception
      final Throwable[] suppressedExceptions = e.getSuppressed();
      if (suppressedExceptions.length > 0) {
        for (final Throwable suppressedException : suppressedExceptions) {
          System.out.println("Suppressed exception: " + suppressedException.getMessage());
        }
      }
    }
  }

  private static void accessDirtyResource() throws Exception {
    try (DirtyResource dirtyResource = new DirtyResource()) {
      dirtyResource.readDirtyResource();
    }
  }

  private static void catchMultipleExceptionsDemo() {
    int[] array = {1, 2, 3};
    try {
      System.out.println(array[10]);
    } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
      // No need of multiple catch statements
      System.out.println(e.getMessage());
    }
  }
}
