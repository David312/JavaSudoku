package javasudoku.exceptions;

public class ValueAlreadySetException extends JavaSudokuException {

  private static final long serialVersionUID = 1L;

  public ValueAlreadySetException() {
    super();
  }

  public ValueAlreadySetException(String message) {
    super(message);
  }

  public ValueAlreadySetException(Throwable throwable) {
    super(throwable);
  }

  public ValueAlreadySetException(String message, Throwable throwable) {
    super(message, throwable);
  }
}