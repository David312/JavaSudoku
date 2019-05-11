package org.david312.board.exceptions;

public class InvalidBoardLocationException extends BoardException {

  private static final long serialVersionUID = 1L;

  public InvalidBoardLocationException() {
    super();
  }

  public InvalidBoardLocationException(String message) {
    super(message);
  }

  public InvalidBoardLocationException(Throwable throwable) {
    super(throwable);
  }

  public InvalidBoardLocationException(String message, Throwable throwable) {
    super(message, throwable);
  }

}