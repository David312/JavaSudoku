package org.david312.board_lib.boards;

import java.util.ArrayList;
import java.util.List;

import org.david312.board_lib.exceptions.InvalidBoardLocationException;
import org.david312.board_lib.factories.TileFactory;
import org.david312.board_lib.tiles.Tile;
import org.david312.board_lib.tiles.TileType;

public class BoardImpl<T> implements Board<T>{
  private static final int MIN_ROW = 0;
  private static final int MIN_COLUMN = 0;

  private final TileFactory tileFactory;
  private final Location minLocation;
  private final Location maxLocation;

  private int rows;
  private int columns;


  private List<List<Tile<T>>> tiles;

  public BoardImpl(int rows, int columns, TileFactory tileFactory) {
    if(rows <= 0 || columns <= 0) {
      throw new IllegalArgumentException("Rows and columns parameters must be greater than zero");
    }
    this.rows = rows;
    this.columns = columns;
    this.tileFactory = tileFactory;
    this.minLocation = new Location(MIN_ROW, MIN_COLUMN);
    this.maxLocation = new Location(rows, columns);
    createTiles();
  }

  private void createTiles() {
    tiles = new ArrayList<>(rows);
    for (int i = 0; i < rows; i++) {
      List<Tile<T>> row = new ArrayList<>(columns);
      for (int j = 0; j < columns; j++) {
        row.add(tileFactory.getTile(TileType.NORMAL));
      }
      tiles.add(row);
    }
  }

  @Override
  public int getTotalRows() {
    return this.rows;
  }

  @Override
  public int getTotalColumns() {
    return this.columns;
  }

  @Override
  public T getValueAt(Location location) {
    checkBoardLocation(location);
    return getTileAt(location).getValue();
  }

  private void checkBoardLocation(Location location) {
    checkMinLocation(location);
    checkMaxLocation(location);
  }

  private void checkMinLocation(Location location) {
    if (location.getX() < minLocation.getX() || location.getY() < minLocation.getY()) {
      throw new InvalidBoardLocationException();
    }
  }

  private void checkMaxLocation(Location location) {
    if (location.getX() > maxLocation.getX() || location.getY() > maxLocation.getY()) {
      throw new InvalidBoardLocationException();
    }
  }

  private Tile<T> getTileAt(Location location) {
    return tiles.get(location.getX()).get(location.getY());
  }

  @Override
  public void setValueAt(Location location, T value) {
    checkBoardLocation(location);
    getTileAt(location).setValue(value);
  }

  @Override
  public void setTileType(Location location, TileType tileType) {
    setTileType(location, tileType, null);
  }

  @Override
  public void setTileType(Location location, TileType tileType, T value) {
    checkBoardLocation(location);
    Tile<T> tile = tileFactory.getTile(tileType);
    tile.setValue(value);
    tiles.get(location.getX()).set(location.getY(), tile);
  }
}