package javasudoku.sudoku;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import javasudoku.entities.Board;
import javasudoku.exceptions.InvalidSudokuPositionModificationException;
import javasudoku.exceptions.InvalidBoardLocationException;

public class SudokuTest {
  private final int MAX_VALUE = 10;
  private Sudoku s;

  private Board<Integer> makeEmptyBoard() {
    Board<Integer> b = new Board<>(Sudoku.ROWS_NUMBER, Sudoku.COLUMNS_NUMBER);
    
    for (int i = 0; i < Sudoku.ROWS_NUMBER; i++) {
      for (int j = 0; j < Sudoku.COLUMNS_NUMBER; j++) {
        b.setCellValue(i, j, 0);
      }
    }

    return b;
  }

  private Sudoku makeEmptySudoku() {
    return new Sudoku(makeEmptyBoard());
  }

  private Board<Integer> makeRandomBoard() {
    Random r = new Random();
    Board<Integer> b = makeEmptyBoard();

    for (int i = 0; i < b.getRowsNumber(); i++) {
      for(int j = 0; j < b.getColumnsNumber(); j++) {
        b.setCellValue(i, j, r.nextInt(MAX_VALUE));
      }
    }

    return b;
  }

  @Test
  public void createEmptySudoku() {
    s = makeEmptySudoku();

    for (int r = 0; r < Sudoku.ROWS_NUMBER; r++) {
      for (int c = 0; c < Sudoku.COLUMNS_NUMBER; c++) {
        assertEquals(0, s.getValueAt(r, c));
      }
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void createSudokuWithInvalidRows() {
    new Sudoku(new Board<>(5, Sudoku.COLUMNS_NUMBER));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createSudokuWithInvalidColumns() {
    new Sudoku(new Board<>(Sudoku.ROWS_NUMBER, 5));
  }

  @Test(expected = IllegalArgumentException.class)
  public void createSudokuWithNullBoardValue() {
    Board<Integer> b = makeEmptyBoard();
    b.setCellValue(5, 5, null);
    new Sudoku(b);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createSudokuWithInvalidGreaterBoardValue() {
    Board<Integer> b = makeEmptyBoard();
    b.setCellValue(5, 5, 20);
    new Sudoku(b);
  }

  @Test(expected = IllegalArgumentException.class)
  public void createSudokuWithInvalidLowerBoardValue() {
    Board<Integer> b = makeEmptyBoard();
    b.setCellValue(5, 5, -1);
    new Sudoku(b);
  }

  @Test 
  public void createFilledSudoku() {
    Board<Integer> b = makeRandomBoard();
    s = new Sudoku(b);

    for (int row = 0; row < Sudoku.ROWS_NUMBER; row++) {
      for (int column = 0; column < Sudoku.COLUMNS_NUMBER; column++) {
        assertEquals(b.getCellValue(row, column), Integer.valueOf(s.getValueAt(row, column)));
      }
    }
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetValueAtWithHighRow() {
    makeEmptySudoku().getValueAt(100, 5);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetValueAtWithHighColumn() {
    makeEmptySudoku().getValueAt(5, 100);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetValueAtWithLowRow() {
    makeEmptySudoku().getValueAt(-1, 5);
  }

  @Test(expected = InvalidBoardLocationException.class)
  public void checkGetValueAtWithLowColumn() {
    makeEmptySudoku().getValueAt(5, -1);
  }

  @Test(expected = InvalidSudokuPositionModificationException.class)
  public void checkCannotModifyPresetCell() {
    Board<Integer> b = makeEmptyBoard();
    b.setCellValue(5, 5, 5);
    s = new Sudoku(b);
    s.setValueAt(5, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkCannotSetInvalidLowValue() {
    makeEmptySudoku().setValueAt(5, 5, -1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkCannotSetInvalidHighValue() {
    makeEmptySudoku().setValueAt(5, 5, 10);
  }

  @Test
  public void checkCanModifyEmptyValue() {
    s = makeEmptySudoku();
    s.setValueAt(5, 5, 5);
    assertEquals(5, s.getValueAt(5, 5));
  }

  @Test
  public void checkCanModifyMultipleTimesEmptyValue() {
    s = makeEmptySudoku();
    s.setValueAt(5, 5, 5);
    assertEquals(5, s.getValueAt(5, 5));
    s.setValueAt(5, 5, 0);
    assertEquals(0, s.getValueAt(5, 5));
  }
}