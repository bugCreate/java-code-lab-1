package com.learn.io.readerandwriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

public class ReaderAndWriterDemo {

  public static void main(String[] args) throws IOException {
    ReaderAndWriterDemo demo = new ReaderAndWriterDemo();
    demo.writerDemo();
  }

  public void readerDemo() throws IOException {
    ClassLoader classLoader = ReaderAndWriterDemo.class.getClassLoader();
    URL resource = classLoader.getResource("test.txt");
    Reader reader = new FileReader(resource.getPath());
    int data = reader.read();
    while (data != -1) {
      char dataChar = (char) data;
      System.out.println(dataChar);
      data = reader.read();
    }
  }
  public void writerDemo() throws IOException {

    try(Writer writer = new FileWriter("/Users/qihaiming/tmp/javaio/test.txt")) {
      writer.write("hahaha");
    }

  }
}
