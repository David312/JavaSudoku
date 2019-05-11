package org.david312.common.exceptions;

public class JavaSudokuException extends RuntimeException {

  private static final long serialVersionUID = 1L; 

  public JavaSudokuException() {
    super();
  }

  public JavaSudokuException(String message) {
    super(message);
  }

  public JavaSudokuException(Throwable throwable) {
    super(throwable);
  }

  public JavaSudokuException(String message, Throwable throwable) {
    super(message, throwable);
  }
  
}