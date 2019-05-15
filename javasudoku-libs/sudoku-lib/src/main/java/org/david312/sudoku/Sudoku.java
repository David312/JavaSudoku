package org.david312.sudoku;

import org.david312.board_lib.boards.Board;
import org.david312.board_lib.boards.Location;
import org.david312.board_lib.exceptions.IllegalTileModificationException;
import org.david312.board_lib.tiles.TileType;
import org.david312.sudoku.exceptions.InvalidSudokuPositionModificationException;

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
    if (b.getTotalRows() != ROWS_NUMBER || b.getTotalColumns() != COLUMNS_NUMBER) {
      throw new IllegalArgumentException("Invalid sudoku dimentions: "
        + b.getTotalRows() + ", " + b.getTotalColumns());
    }
  }

  private void checkBoardValues(Board<Integer> filledBoard) {
    for (int r = 0; r < ROWS_NUMBER; r++) {
      for (int c = 0; c < COLUMNS_NUMBER; c++) {
        checkValueValidity(filledBoard.getValueAt(Location.at(r, c)));
      }
    }  
  }

  private void checkValueValidity(Integer value) {
    if (!isValidValue(value)) {
      throw new IllegalArgumentException("Invalid board_lib value: " + value);
    }
  }

  private boolean isValidValue(Integer value) {
    return value != null && value >= MIN_VALUE && value <= MAX_VALUE;
  }
  
  private void copyFilledBoard(Board<Integer> other) {
    this.board = other;
    for (int row = 0; row < ROWS_NUMBER; row++) {
      for (int col = 0; col < COLUMNS_NUMBER; col++) {
        Integer value = other.getValueAt(Location.at(row, col));
        if (value != MIN_VALUE) {
          board.setTileType(Location.at(row, col), TileType.INMUTABLE, value);
        }
        else {
          board.setTileType(Location.at(row, col), TileType.NORMAL, 0);
        }
      }
    }
  }

  public int getValueAt(int row, int column) {
    return board.getValueAt(new Location(row, column));
  }

  public void setValueAt(int row, int column, int value) {
    checkValueValidity(Integer.valueOf(value));
    try {
      board.setValueAt(new Location(row, column), value);
    } catch (IllegalTileModificationException e) {
      throw new InvalidSudokuPositionModificationException();
    }
  }
  
}