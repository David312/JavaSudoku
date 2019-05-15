package org.david312.board_lib.boards;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.david312.board_lib.factories.AbstractFactory;
import org.david312.board_lib.factories.BoardFactory;
import org.david312.board_lib.tiles.TileType;
import org.junit.Before;
import org.junit.Test;

import org.david312.board_lib.exceptions.InvalidBoardLocationException;

public class BoardTest {

  private final int rows = 5;
  private final int columns = 5;
  private final BoardFactory boardFactory = AbstractFactory.getBoardFactory();
  private final Location invalidXLocation = new Location(-1, 1);
  private final Location invalidYLocation = new Location(1, -1);
  private final Location validLocation = new Location(1, 1);

  private Board<Integer> b;


  @Before
  public void setup() {
    b = (Board<Integer>) boardFactory.getBoard(rows, columns);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructorRowParameterIsChecked() {
    boardFactory.getBoard(0, columns);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructorColumnsParameterIsChecked() {
    boardFactory.getBoard(rows, 0);
  }

  @Test
  public void checkTilesAreEmptyInAEmptyBoard() {
    for(int x = 0; x < b.getTotalRows(); x++) {
      for(int y = 0; y < b.getTotalColumns(); y++) {
        assertNull(b.getValueAt(makeLocation(x, y)));
      }
    }
  }

  private Location makeLocation(int x, int y) {
    return new Location(x, y);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetTileValueWithInvalidRow() {
    b.getValueAt(invalidXLocation);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetTileValueWithInvalidColumn() {
    b.getValueAt(invalidYLocation);
  }

  @Test
  public void checkGetTileValueWithValidLocation() {
    assertNull(b.getValueAt(validLocation));
  }

  @Test
  public void checkSetTileValueValidLocation() {
    b.setValueAt(validLocation,1);
    assertEquals(Integer.valueOf(1), b.getValueAt(validLocation));
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileValueInvalidRow() {
    b.setValueAt(invalidXLocation, 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileValueInvalidColumn() {
    b.setValueAt(invalidYLocation, 1);
  }

  @Test
  public void checkSetTileValidLocation() {
    b.setTileType(validLocation, TileType.NORMAL, 1);
    assertEquals(Integer.valueOf(1), b.getValueAt(validLocation));
  }

  @Test
  public void checkSetTileWithNullValidLocation() {
    b.setTileType(validLocation, TileType.NORMAL);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileInvalidRow() {
    b.setTileType(invalidXLocation, TileType.NORMAL);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileInvalidColumn() {
    b.setTileType(invalidYLocation, TileType.NORMAL);
  }
}