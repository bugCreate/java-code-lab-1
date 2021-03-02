package com.demo.security.encode;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
  public static void main(String[] args) throws UnsupportedEncodingException {
    StringBuilder sb = new StringBuilder();
    String raw = "java 8 base 64 demo.";
    String base64encoded = Base64.getEncoder().encodeToString(raw.getBytes("utf-8"));
    System.out.println("base64 encoded:" + base64encoded);
    String decoded = new String(Base64.getDecoder().decode(base64encoded), "utf-8");
    System.out.println("decoded:" + decoded);
    String url = "http://www.demo.com?test=asda&name=asda";
    String urlencoded = Base64.getUrlEncoder().encodeToString(url.getBytes("utf-8"));
    System.out.println("url encoded:" + urlencoded);
    String urlDecoded = new String(Base64.getUrlDecoder().decode(urlencoded), "utf-8");
    System.out.println("url decoded:" + urlDecoded);
  }
}
