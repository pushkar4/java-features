public class CustomResource implements AutoCloseable {

  @Override
  public void close() throws Exception {
    System.out.println("Closing Custom Resource");
  }

  public void readCustomResource() {
    System.out.println("Reading Custom Resource");
  }
}
