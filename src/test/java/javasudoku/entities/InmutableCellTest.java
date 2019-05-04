package javasudoku.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javasudoku.exceptions.InmutableCellModificationException;

public class InmutableCellTest {
  private InmutableCell<Integer> c;

  @Test
  public void createWithDefaultValue() {
    c = new InmutableCell<>(1);
  }

  @Test
  public void checkValueIsSetWhenPassingParametersToConstructor() {
    c = new InmutableCell<>(1);
    assertTrue(c.isValueSet());
  }

  @Test
  public void checkValueIsNotSetWhenUsingDefaultConstructor() {
    c = new InmutableCell<>();
    assertFalse(c.isValueSet());
  }

  @Test
  public void checkIsValueSetAfterUsingSetMethod() {
    c = new InmutableCell<>();
    c.setValue(0);
    assertTrue(c.isValueSet());
  }

  @Test(expected = InmutableCellModificationException.class)
  public void checkCannotSetValueTwice() {
    c = new InmutableCell<>();
    c.setValue(0);
    c.setValue(0);
  }

  @Test(expected = InmutableCellModificationException.class)
  public void checkCannotSetValueWhenPassingValueInConstructor() {
    c = new InmutableCell<>(0);
    c.setValue(0);
  }


}