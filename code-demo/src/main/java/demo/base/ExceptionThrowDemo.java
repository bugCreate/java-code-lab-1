package demo.base;

public class ExceptionThrowDemo {
  public static void main(String[] args) {
    try {
      throw new Myexception();

    }catch (Exception e){
      System.out.println("lalala");
      System.out.println(e);
    }

  }

  static class Myexception extends Exception{

  }
}
