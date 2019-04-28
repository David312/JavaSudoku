package javasudoku.exceptions;

public class InvalidCellValueException extends JavaSudokuException {

  private static final long serialVersionUID = 1L;

  public InvalidCellValueException() {
    super();
  }

  public InvalidCellValueException(String message) {
    super(message);
  }

  public InvalidCellValueException(Throwable throwable) {
    super(throwable);
  }

  public InvalidCellValueException(String message, Throwable throwable) {
    super(message, throwable);
  }
}