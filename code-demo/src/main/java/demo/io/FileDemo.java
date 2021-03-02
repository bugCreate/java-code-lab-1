package demo.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
  public static void main(String[] args) {

  }

  static void listAllFile() throws IOException {
    File dir = new File("/Users/qihaiming/tmp/demo");
    File file = new File("/Users/qihaiming/tmp/test1.txt");
    if (!dir.exists()) {
      System.out.println(dir.mkdir());
    }
    if (!file.exists()) {
      System.out.println(file.createNewFile());
    }
    String[] sub = dir.list();
    File[] files = dir.listFiles();
  }

  static void pathdemo()
  {
    Path path = Paths.get("/Users/qihaiming/tmp/test1.txt");
    Path path1 = FileSystems.getDefault().getPath("/Users/qihaiming/tmp/test1.txt");

  }
}
