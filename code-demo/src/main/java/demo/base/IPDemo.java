package demo.base;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class IPDemo {
  public static void main(String[] args) throws IOException {
//    InetAddress ia = InetAddress.getLocalHost();
//    String host = ia.getHostName();//获取计算机主机名
//    String IP = ia.getHostAddress();//获取计算机IP
//    System.out.println(host);
//
//    InetAddress address = InetAddress.getByName("www.baidu.com");
//
//    System.out.println(address);
//
//    System.out.println("-----");
//
//    InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
//
//    for (InetAddress addr : addresses) {
//
//      System.out.println(addr);
//
//    }
    InetAddress remote = InetAddress.getByName("10.120.171.13");
    System.out.println(remote.isReachable(1000));

  }

}

