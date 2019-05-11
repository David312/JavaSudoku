package org.david312.board;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.david312.board.exceptions.InvalidBoardLocationException;

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
    new Board<Integer>(0, columns);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkConstructorColumnsParameterIsChecked() {
    new Board<Integer>(rows, 0);
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
  
  @Test
  public void checkSetCellValidLocation() {
    b.setCell(1, 1, new Cell<>(1));
    assertEquals(Integer.valueOf(1), b.getCellValue(1,1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkSetCellWithNullInValidLocation() {
    b.setCell(1, 1, null);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellInvalidRow() {
    b.setCell(-1, 1, new Cell<>(1));
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkSetCellInvalidColumn() {
    b.setCell(1, -1, new Cell<>(1));
  }
}