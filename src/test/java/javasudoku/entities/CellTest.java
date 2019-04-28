package javasudoku.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javasudoku.exceptions.InvalidCellValueException;

public class CellTest {
  private Cell c;
 
  private Cell createCell() {
    return new Cell();
  }
  private Cell createCell(int value) {
    return new Cell(value);
  }

  @Test(expected = InvalidCellValueException.class)
  public void cellWithNegativeValue() {
    createCell(-1);
  }  

  @Test(expected = InvalidCellValueException.class)
  public void cellWithExceedingMaxValue() {
    createCell(Cell.MAX_VALUE + 1);
  }

  @Test(expected = InvalidCellValueException.class)
  public void cellWithLoweringMinValue() {
    createCell(Cell.MIN_VALUE - 1);  
  }

  @Test
  public void defaultConstructor() {
    c = createCell();
    assertEquals(Cell.EMPTY_VALUE, c.getValue());
  }

  @Test(expected = InvalidCellValueException.class)
  public void setValueWithBelowMinValue() {
    c = createCell();
    c.setValue(Cell.MIN_VALUE - 1);
  }

  @Test(expected = InvalidCellValueException.class)
  public void setValueWithAboveMaxValue() {
    c = createCell();
    c.setValue(Cell.MAX_VALUE + 1);
  }

  @Test(expected = InvalidCellValueException.class)
  public void setValueWithNegativeValue() {
    c = createCell();
    c.setValue(-1);
  }

  @Test
  public void setValueValidValue() {
    c = createCell();
    c.setValue(Cell.MAX_VALUE - 1);
    assertEquals(Cell.MAX_VALUE - 1, c.getValue());
  }

  @Test 
  public void toStringNonEmptyValue() {
    c = createCell(Cell.MAX_VALUE);
    assertEquals(String.format("[%s]", c.getValue()), c.toString());
  }

  @Test
  public void toStringEmptyValue() {
    c = createCell();
    assertEquals(String.format("[%s]", " "), c.toString());
  }

  @Test
  public void equalsWithNull() {
    c = createCell();
    assertFalse(c.equals(null));
  }

  @Test
  public void equalsWithNonInstanceOfCell() {
    c = createCell();
    assertFalse(c.equals(new Object()));
  }

  @Test
  public void equalsWithSelf() {
    c = createCell();
    assertTrue(c.equals(c));
  }

  @Test
  public void equalsWithOtherWithSameValue() {
    c = createCell();
    Cell other = createCell();
    assertTrue(c.equals(other));
  }

  @Test
  public void notEqualsWithOtherWithDifferentValue() {
    c = createCell();
    Cell other = createCell(Cell.MAX_VALUE);
    assertFalse(c.equals(other));
  }
}