package javasudoku.sudoku;

import javasudoku.entities.Board;
import javasudoku.entities.Cell;
import javasudoku.entities.InmutableCell;
import javasudoku.exceptions.InmutableCellModificationException;
import javasudoku.exceptions.InvalidSudokuPositionModificationException;

public class Sudoku {
  public static final int ROWS_NUMBER = 9;
  public static final int COLUMNS_NUMBER = 9;

  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 9;
  
  private Board<Integer> board;
  
  public Sudoku(Board<Integer> filledBoard) {
    checkBoardDimentions(filledBoard);
    checkBoardValues(filledBoard);
    copyFilledBoard(filledBoard);
  }
  
  private void checkBoardDimentions(Board<Integer> b) {
    if (b.getRowsNumber() != ROWS_NUMBER || b.getColumnsNumber() != COLUMNS_NUMBER) {
      throw new IllegalArgumentException("Invalid board dimentions: " 
        + b.getRowsNumber() + ", " + b.getColumnsNumber());
    }
  }

  private void checkBoardValues(Board<Integer> filledBoard) { 
    for (int r = 0; r < ROWS_NUMBER; r++) {
      for (int c = 0; c < COLUMNS_NUMBER; c++) {
        checkValueValidity(filledBoard.getCellValue(r, c));
      }
    }  
  }

  private void checkValueValidity(Integer value) {
    if (!isValidValue(value)) {
      throw new IllegalArgumentException("Invalid board value: " + value);
    }
  }

  private boolean isValidValue(Integer value) {
    return value != null && value >= MIN_VALUE && value <= MAX_VALUE;
  }
  
  private void copyFilledBoard(Board<Integer> b) {
    this.board = new Board<>(ROWS_NUMBER, COLUMNS_NUMBER);
    
    for (int row = 0; row < ROWS_NUMBER; row++) {
      for (int col = 0; col < COLUMNS_NUMBER; col++) {
        Integer value = b.getCellValue(row, col);
        if (value != MIN_VALUE) {
          board.setCell(row, col, new InmutableCell<Integer>(value));
        }
        else {
          board.setCell(row, col, new Cell<Integer>(0));
        }
      }
    }
  }

  public int getValueAt(int row, int column) {
    return board.getCellValue(row, column);
  }

  public void setValueAt(int row, int column, int value) {
    checkValueValidity(Integer.valueOf(value));
    try {
      board.setCellValue(row, column, value);
    } catch (InmutableCellModificationException e) {
      throw new InvalidSudokuPositionModificationException();
    }
  }
  
}