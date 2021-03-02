package com.demo.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Demo {
  private static String getMd5Str(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    byte[] digest = null;
    MessageDigest md5 = MessageDigest.getInstance("md5");
    digest = md5.digest(str.getBytes("utf-8"));
    String md5Str = new BigInteger(1, digest).toString(16);
    return md5Str;
  }

  public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    String str = "asdasdiuqhddnamkcaiuhdcalmcnzhxcojhoidnqldnaz,mcnajhlkjqwklwn,man c,nsdlkasldl mlaa";
    System.out.println(getMd5Str(str));
  }
}
