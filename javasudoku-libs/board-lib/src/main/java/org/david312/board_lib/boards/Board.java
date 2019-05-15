package org.david312.board_lib.boards;

import org.david312.board_lib.tiles.TileType;

public interface Board<T> {
  int getTotalRows();
  int getTotalColumns();
  T getValueAt(Location location);
  void setValueAt(Location location, T value);
  void setTileType(Location location, TileType tileType);
  void setTileType(Location location, TileType tileType, T value);
}
