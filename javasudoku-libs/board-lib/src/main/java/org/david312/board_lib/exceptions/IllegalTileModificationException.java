package org.david312.board_lib.exceptions;

public class IllegalTileModificationException extends BoardException {

  private static final long serialVersionUID = 1L;

  public IllegalTileModificationException() {
    super();
  }

  public IllegalTileModificationException(String message) {
    super(message);
  }

  public IllegalTileModificationException(Throwable throwable) {
    super(throwable);
  }

  public IllegalTileModificationException(String message, Throwable throwable) {
    super(message, throwable);
  }
}