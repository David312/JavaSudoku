package org.david312.board_lib.factories;

import org.david312.board_lib.tiles.InmutableTile;
import org.david312.board_lib.tiles.NormalTile;
import org.david312.board_lib.tiles.Tile;
import org.david312.board_lib.tiles.TileType;

class TileFactoryImpl implements TileFactory {
  @Override
  public Tile getTile(TileType type) {
    switch (type) {
      case NORMAL:
        return new NormalTile<>();
      case INMUTABLE:
        return new InmutableTile<>();
      default:
        throw new IllegalArgumentException();
    }
  }
}
