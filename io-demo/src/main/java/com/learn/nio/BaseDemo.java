package com.learn.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BaseDemo {
  private void base(){
    try(RandomAccessFile afile= new RandomAccessFile("","rw")) {

      FileChannel inChannel = afile.getChannel();
      ByteBuffer byteBuffer = ByteBuffer.allocate(48);
      int byteReader = inChannel.read(byteBuffer);
      while (byteReader!= -1){
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
          System.out.println((char) byteBuffer.get());
        }
        byteBuffer.clear();
        byteReader = inChannel.read(byteBuffer);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
