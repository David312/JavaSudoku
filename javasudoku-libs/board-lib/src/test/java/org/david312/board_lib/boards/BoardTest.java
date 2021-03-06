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
  public void checkGetTileValueWithInvalidMinRow() {
    b.getValueAt(invalidXLocation);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetTileValueWithInvalidMinColumn() {
    b.getValueAt(invalidYLocation);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetTileValueWithInvalidMaxRow() {
    b.getValueAt(new Location(b.getTotalRows() + 1, 1));
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetTileValueWithInvalidMaxColumn() {
    b.getValueAt(new Location(1, b.getTotalColumns() + 1));
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
  public void checkSetTileValueInvalidMinRow() {
    b.setValueAt(invalidXLocation, 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileValueInvalidMinColumn() {
    b.setValueAt(invalidYLocation, 1);
  }


  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileValueInvalidMaxRow() {
    b.setValueAt(new Location(b.getTotalRows() + 1, 1), 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileValueInvalidMaxColumn() {
    b.setValueAt(new Location(1, b.getTotalColumns() + 1), 1);
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
  public void checkSetTileInvalidMinRow() {
    b.setTileType(invalidXLocation, TileType.NORMAL);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileInvalidMinColumn() {
    b.setTileType(invalidYLocation, TileType.NORMAL);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileInvalidMaxRow() {
    b.setTileType(new Location(b.getTotalRows() + 1, 1), TileType.NORMAL);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetTileInvalidMaxColumn() {
    b.setTileType(new Location(1, b.getTotalColumns() + 1), TileType.NORMAL);
  }
}