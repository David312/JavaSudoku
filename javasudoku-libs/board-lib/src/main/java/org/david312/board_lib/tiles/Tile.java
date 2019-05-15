package org.david312.board_lib.tiles;

public interface Tile<T> {
  T getValue();
  void setValue(T value);

  @Override
  boolean equals(Object o);
}
