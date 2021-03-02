package demo.failsafe.exception;

public class FailRuntimeException extends RuntimeException {
  public FailRuntimeException() {
    super();
  }

  public FailRuntimeException(String message) {
    super(message);
  }

  public FailRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
