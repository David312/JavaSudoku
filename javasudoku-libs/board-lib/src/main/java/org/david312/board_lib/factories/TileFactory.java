package org.david312.board_lib.factories;

import org.david312.board_lib.tiles.Tile;
import org.david312.board_lib.tiles.TileType;

public interface TileFactory {
  Tile getTile(TileType type);
}
