package javasudoku.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javasudoku.exceptions.InvalidBoardLocationException;
import javasudoku.exceptions.InvalidCellValueException;

public class BoardTest {
  private Board b;

  @Before
  public void setup() {
    b = new Board();
  }

  @Test
  public void checkCellsAreEmptyInAEmptyBoard() {
    Cell emptyCell = new Cell();
    for(int i = 0; i < Board.ROWS; i++) {
      for(int j = 0; j < Board.COLUMNS; j++) {
        assertEquals(emptyCell.getValue(), b.getCellValue(i,j));
      }
    }
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetCellValueWithInvalidRow() {
    b.getCellValue(-1, 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetCellValueWithInvalidColumn() {
    b.getCellValue(1, -1);
  }

  @Test
  public void checkGetCellValueWithValidLocation() {
    Cell emptyCell = new Cell();
    assertEquals(emptyCell.getValue(), b.getCellValue(1, 1));
  }

  @Test
  public void checkSetCellValueValidLocation() {
    b.setCellValue(1,1,1);
    assertEquals(1, b.getCellValue(1,1));
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellValueInvalidRow() {
    b.setCellValue(-1, 1, 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellValueInvalidColumn() {
    b.setCellValue(1, -1, 1);
  }

  @Test(expected = InvalidCellValueException.class)
  public void checkSetCellValueInvalidValue() {
    b.setCellValue(1, 1, Cell.MIN_VALUE - 1);
  }
}