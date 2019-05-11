package org.david312.board;


import static org.junit.Assert.assertEquals;

import java.util.List;

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

  @Test
  public void checkGetRow() {
    final int N = columns;
    for (int i = 0; i < N; i++) {
      b.setCellValue(0, i, i);
    }
    
    List<Cell<Integer>> row = b.getRow(0);

    for (int i = 0; i < N; i++) {
      assertEquals(Integer.valueOf(i), row.get(i).getValue());
    }
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetRowWithNegativeRow() {
    b.getRow(-1);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetRowWithHigerThanMaximumRow() {
    b.getRow(rows + 1);
  }

  @Test 
  public void checkGetColumn() {
    final int M = rows;
    for (int i = 0; i < M; i++) {
      b.setCellValue(i, 0, i);
    }

    List<Cell<Integer>> column = b.getColumn(0);

    for (int i = 0; i < M; i++) {
      assertEquals(Integer.valueOf(i), column.get(i).getValue());
    }
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetColumnWithNegativeColumn() {
    b.getColumn(-1);  
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetColumnWithHigherThanMaximumColumn() {
    b.getColumn(columns + 1);
  }

  


}