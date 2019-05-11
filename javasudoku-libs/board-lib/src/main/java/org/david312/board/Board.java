package org.david312.board;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.david312.board.exceptions.InvalidBoardLocationException;

public class Board<T> {
  private static final int MIN_ROW = 0;
  private static final int MIN_COLUMN = 0;
  
  private int rows;
  private int columns;

  private List<List<Cell<T>>> cells;

  public Board(int rows, int columns) {
    if(rows <= 0 || columns <= 0) {
      throw new IllegalArgumentException("Rows and columns parameters must be greater than zero");
    }
    this.rows = rows;
    this.columns = columns;
    createCellInstances();
  }

  private void createCellInstances() {
    cells = new ArrayList<>(rows);
    for (int i = 0; i < rows; i++) {
      List<Cell<T>> row = new ArrayList<>(columns);
      for (int j = 0; j < columns; j++) {
        row.add(new Cell<T>());
      }
      cells.add(row);
    }
  }

  public int getRowsNumber() {
    return this.rows;
  }

  public int getColumnsNumber() {
    return this.columns;
  }

  public T getCellValue(int row, int column) {
    checkBoardLocation(row, column);
    return cells.get(row).get(column).getValue();
  }

  public void setCellValue(int row, int column, T value) {
    checkBoardLocation(row, column);
    cells.get(row).get(column).setValue(value);
  }

  public void setCell(int row, int column, Cell<T> cell) {
    if (cell == null) {
      throw new IllegalArgumentException();
    }
    checkBoardLocation(row, column);
    cells.get(row).set(column, cell);    
  }

  private void checkBoardLocation(int row, int column) {
    checkRowLocation(row);
    checkColumnLocation(column);
  }

  private void checkRowLocation(int row) {
    if (row < MIN_ROW || row > rows) {
      throw new InvalidBoardLocationException("Invalid row -> " + row);
    }
  }

  private void checkColumnLocation(int column) {
    if (column < MIN_COLUMN || column > columns) {
      throw new InvalidBoardLocationException("Invalid column -> " + column);
    }
  }

public List<Cell<T>> getRow(int row) {
  checkRowLocation(row);
  return this.cells.get(row);
}

public List<Cell<T>> getColumn(int column) {
  checkColumnLocation(column); 
  return this.cells.stream()
    .map(l -> l.get(column))
    .collect(Collectors.toList());
}
  
}