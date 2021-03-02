package demo.failsafe;

import demo.failsafe.exception.FailException;
import demo.failsafe.exception.FailRuntimeException;
import net.jodah.failsafe.CircuitBreaker;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;

import java.time.Duration;

/**
 * https://jodah.net/failsafe/
 * */
public class FailsafeDemo {
  public static void main(String[] args) {
    retry();

    circuitBreaker();

  }

  private static void runtimeException() {
    System.out.println("fail");
    throw new FailRuntimeException("fail");
  }

  private static void runtimeBaseException() {
    System.out.println("lalala");
    throw new RuntimeException("lalala");
  }

  private static void Exception() throws FailException {
    System.out.println("fail");
    throw new FailException("fail");
  }

  private static String returnNull() {
    System.out.println("null");
    return null;
  }

  private static void baseException() throws Exception {
    System.out.println("lalal");
    throw new Exception("lalala");
  }

  private static void retry() {
    RetryPolicy<Object> retryPolicy =
        new RetryPolicy<>().handle(FailException.class, FailRuntimeException.class).handleResult(null).withDelay(
            Duration.ofSeconds(1)).withMaxRetries(3);
    //Failsafe.with(retryPolicy).run(FailsafeDemo::runtimeException);
    //Failsafe.with(retryPolicy).run(FailsafeDemo::runtimeBaseException);
    Failsafe.with(retryPolicy).run(FailsafeDemo::returnNull);
  }

  private static void circuitBreaker() {
    int i = 0;
    RetryPolicy<Object> retryPolicy =
        new RetryPolicy<>().handle(FailException.class, FailRuntimeException.class).handleResult(null).withDelay(
            Duration.ofSeconds(1)).withMaxRetries(3);
    CircuitBreaker<Object> circuitBreaker =
        new CircuitBreaker<>().handle(FailException.class).withFailureThreshold(3, 10).withSuccessThreshold(
            5).withDelay(Duration.ofMillis(500)).onClose(() -> System.out.println("close")).onOpen(
            () -> System.out.println("open")).onHalfOpen(() -> System.out.println("halfopen"));
    while (true) {
      try {
        Failsafe.with(retryPolicy, circuitBreaker).run(FailsafeDemo::Exception);
      } catch (Throwable e) {
        i++;
        System.out.println("......." + i);
      }
    }
  }
}
