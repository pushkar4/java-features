public class BinaryLiterals {

  public static void main(String[] args) {

    byte b = 0b11;
    short s = 0B000001111;
    int i = 0B10001010111;
    long l = 0b0001011110101111;

    System.out.println("Byte Number is " + b);
    System.out.println("Short Number is " + s);
    System.out.println("Int Number is " + i);
    System.out.println("Long Number is " + l);

    int n = 15;
    System.out.println("Is decimal and binary same: " + (s == n));
    System.out.println("Long multiplied by 2: " + (l * 2));
  }
}
