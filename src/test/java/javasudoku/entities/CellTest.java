package javasudoku.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CellTest {

  private Cell<Integer> c;
 
  private Cell<Integer> createCell() {
    return new Cell<Integer>();
  }
  private Cell<Integer> createCell(int value) {
    return new Cell<Integer>(value);
  }

  @Test
  public void defaultConstructor() {
    c = createCell();
    assertEquals(null, c.getValue());
  }

  @Test
  public void setValueValidValue() {
    c = createCell();
    c.setValue(0);
    assertEquals(Integer.valueOf(0), c.getValue());
  }

  @Test 
  public void toStringNonEmptyValue() {
    c = createCell(0);
    assertEquals(String.format("[%s]", c.getValue()), c.toString());
  }

  @Test
  public void toStringEmptyValue() {
    c = createCell();
    assertEquals("[null]", c.toString());
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
  public void equalsWithOtherWithSameNullValue() {
    c = createCell();
    Cell<Integer> other = createCell();
    assertTrue(c.equals(other));
  }

  @Test
  public void notEqualsWithOtherWithNonNullValue() {
    c = createCell();
    Cell<Integer> other = createCell(0);
    assertFalse(c.equals(other));
  }

  @Test
  public void equalsWithNonNullValues() {
    c = createCell(0);
    Cell<Integer> other = createCell(0);
    assertTrue(c.equals(other));
  }

  @Test
  public void nonEqualsNonNullCellWithNull() {
    c = createCell();
    assertFalse(c.equals(null));
  }
}