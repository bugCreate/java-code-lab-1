package demo.base;

import java.io.IOException;

public class RuntimeDemo {
  public static void main(String[] args) throws IOException {
    Runtime.getRuntime().exec("echo lala");
    Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("exit")));
  }
}
