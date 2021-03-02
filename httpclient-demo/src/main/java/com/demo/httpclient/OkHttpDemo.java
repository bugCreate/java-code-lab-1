package com.demo.httpclient;

import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * HTTP/2 support allows all requests to the same host to share a socket.
 * Connection pooling reduces request latency (if HTTP/2 isn’t available).
 * Transparent GZIP shrinks download sizes.
 * Response caching avoids the network completely for repeat requests.
 * https://www.jianshu.com/p/ca8a982a116b
 * event 和拦截器适合做监控审计
 */
public class OkHttpDemo {
  public static void main(String[] args) throws Exception {
    get();
    post();
    try {
      config();
    }catch (Exception e){
      e.printStackTrace();
    }
    events();
  }

  public static void get() throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient();
    Request request = new Request.Builder().url("http://localhost:8080/demo/servername").build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      System.out.println(response.body().string());
    }
  }

  public static void post() throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient();
    RequestBody body = RequestBody.create("{}", MediaType.get("application/json; charset=utf-8"));
    Request request = new Request.Builder().url("http://localhost:8080/demo/user").post(body).build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      System.out.println(response.body().string());
    }
  }

  public static void config() throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient.Builder().callTimeout(10, TimeUnit.MILLISECONDS).connectTimeout(22,
        TimeUnit.MILLISECONDS).build();
    Request request = new Request.Builder().url("http://localhost:8080/demo/servername").build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      System.out.println(response.body().string());
    }
  }

  public static void events() throws IOException {
    OkHttpClient okHttpClient = new OkHttpClient.Builder().eventListener(new PrintingEventListener()).build();
    Request request = new Request.Builder().url("http://localhost:8080/demo/servername").build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      System.out.println(response.body().string());
    }
  }

  static class PrintingEventListener extends EventListener {
    private long callStartNanos;

    private void printEvent(String name) {
      long nowNanos = System.nanoTime();
      if (name.equals("callStart")) {
        callStartNanos = nowNanos;
      }
      long elapsedNanos = nowNanos - callStartNanos;
      System.out.printf("%.3f %s%n", elapsedNanos / 1000000000d, name);
    }

    @Override
    public void callStart(Call call) {
      printEvent("callStart");
    }

    @Override
    public void callEnd(Call call) {
      printEvent("callEnd");
    }

  }
}
