package javasudoku.entities;

import javasudoku.exceptions.InvalidCellValueException;

public class Cell {
  public static final int MIN_VALUE = 0;
  public static final int MAX_VALUE = 9;
  public static final int EMPTY_VALUE = 0;
  
  private static final String FORMAT = "[%s]";

  private int value;

  public Cell() {
    this(EMPTY_VALUE);
  }

  public Cell(int value) {
    checkValue(value);
    this.value = value;
  }

  private void checkValue(int value) {
    if (value < MIN_VALUE || value > MAX_VALUE) {
      throw new InvalidCellValueException("Invalid Cell value: " + value);
    }
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(int value) {
    checkValue(value);
    this.value = value;
  }

  @Override
  public String toString() {
    String strValue = this.value != EMPTY_VALUE ? ""+this.value : " ";
    return String.format(FORMAT, strValue);
  }

  @Override 
  public boolean equals(Object o) {
    if (o == null || !(o instanceof Cell)) {
      return false;
    }
    else if (o == this) {
      return true;
    }
    else {
      Cell other = (Cell) o;
      return this.value == other.getValue();
    }
  }
}