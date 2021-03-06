package org.david312.sudoku.exceptions;

public class InvalidSudokuPositionModificationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidSudokuPositionModificationException() {
    super();
  }

  public InvalidSudokuPositionModificationException(String message) {
    super(message);
  }

  public InvalidSudokuPositionModificationException(Throwable throwable) {
    super(throwable);
  }

  public InvalidSudokuPositionModificationException(String message, Throwable throwable) {
    super(message, throwable);
  }
}