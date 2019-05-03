package javasudoku.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import javasudoku.exceptions.InvalidBoardLocationException;

public class BoardTest {
  private Board<Integer> b;
  private final int rows = 5;
  private final int columns = 5;

  @Before
  public void setup() {
    b = new Board<Integer>(rows, columns);
  }
 
  @Test(expected = IllegalArgumentException.class)
  public void checkConstructorRowParameterIsChecked() {
    Board<Integer> b = new Board<Integer>(0, columns);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructorColumnsParameterIsChecked() {
    Board<Integer> b = new Board<Integer>(rows, 0);
  }

  @Test
  public void checkCellsAreEmptyInAEmptyBoard() {
    Cell<Integer> emptyCell = new Cell<Integer>();
    for(int i = 0; i < b.getRowsNumber(); i++) {
      for(int j = 0; j < b.getColumnsNumber(); j++) {
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
    Cell<Integer> emptyCell = new Cell<Integer>();
    assertEquals(emptyCell.getValue(), b.getCellValue(1, 1));
  }

  @Test
  public void checkSetCellValueValidLocation() {
    b.setCellValue(1,1,1);
    assertEquals(Integer.valueOf(1), b.getCellValue(1,1));
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellValueInvalidRow() {
    b.setCellValue(-1, 1, 1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellValueInvalidColumn() {
    b.setCellValue(1, -1, 1);
  }
}