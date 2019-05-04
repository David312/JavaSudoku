package javasudoku.exceptions;

public class InmutableCellModificationException extends JavaSudokuException {

  private static final long serialVersionUID = 1L;

  public InmutableCellModificationException() {
    super();
  }

  public InmutableCellModificationException(String message) {
    super(message);
  }

  public InmutableCellModificationException(Throwable throwable) {
    super(throwable);
  }

  public InmutableCellModificationException(String message, Throwable throwable) {
    super(message, throwable);
  }
}