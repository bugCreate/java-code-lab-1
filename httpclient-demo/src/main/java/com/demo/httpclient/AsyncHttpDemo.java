package com.demo.httpclient;

import static org.asynchttpclient.Dsl.get;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步http client 支持react websocket
 * https://github.com/AsyncHttpClient/async-http-client
 * */
public class AsyncHttpDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    base();
  }
  static void base() throws ExecutionException, InterruptedException {
    AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
    Future<Response> respone = asyncHttpClient.prepareGet("http://localhost:8080/demo/servername").execute();
    Request request = get("http://localhost:8080/demo/servername").build();
    Future<Response> responseFuture = asyncHttpClient.executeRequest(request);
    System.out.println(respone.get().getStatusCode());
  }
}
