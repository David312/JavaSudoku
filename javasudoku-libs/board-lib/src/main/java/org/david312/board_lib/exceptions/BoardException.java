package org.david312.board_lib.exceptions;

public class BoardException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BoardException() {
    super();
  }

  public BoardException(String message) {
    super(message);
  }

  public BoardException(Throwable throwable) {
    super(throwable);
  }

  public BoardException(String message, Throwable throwable) {
    super(message, throwable);
  }

}