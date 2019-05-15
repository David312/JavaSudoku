package org.david312.board_lib.boards;

public class Location {

  private final int x;
  private final int y;

  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public static Location at(int x, int y) {
    return new Location(x, y);
  }
}
