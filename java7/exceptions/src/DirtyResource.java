public class DirtyResource implements AutoCloseable {
  @Override
  public void close() throws Exception {
    throw new NullPointerException("Dirty Resource won't close, will throw NPE :)");
  }

  public void readDirtyResource() {
    throw new RuntimeException("Dirty Resource cannot be read :P");
  }
}
