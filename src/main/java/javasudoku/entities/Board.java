package javasudoku.entities;

import java.util.ArrayList;
import java.util.List;

import javasudoku.exceptions.InvalidBoardLocationException;

public class Board {
  public static final int ROWS = 9;
  public static final int COLUMNS = 9;

  private static final int MIN_ROW = 0;
  private static final int MIN_COLUMN = 0;
  

  private List<List<Cell>> cells;

  public Board() {
    createCellInstances();
  }

  private void createCellInstances() {
    cells = new ArrayList<>(ROWS);
    for (int i = 0; i < ROWS; i++) {
      List<Cell> row = new ArrayList<>(COLUMNS);
      for (int j = 0; j < COLUMNS; j++) {
        row.add(new Cell());
      }
      cells.add(row);
    }
  }

  public int getCellValue(int row, int column) {
    checkBoardLocation(row, column);
    return cells.get(row).get(column).getValue();
  }

  public void setCellValue(int row, int column, int value) {
    checkBoardLocation(row, column);
    cells.get(row).get(column).setValue(value);
  }

  private void checkBoardLocation(int row, int column) {
    if (row < MIN_ROW || row > ROWS
        || column < MIN_COLUMN || column > COLUMNS) {
      throw new InvalidBoardLocationException(
        "Invalid board location: row -> " + row + " column -> " + column);
    }
  }
  
}