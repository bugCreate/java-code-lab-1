package demo.failsafe.exception;

public class FailException extends Exception {
  public FailException() {
    super();
  }

  public FailException(String message) {
    super(message);
  }

  public FailException(String message, Throwable cause) {
    super(message, cause);
  }
}
