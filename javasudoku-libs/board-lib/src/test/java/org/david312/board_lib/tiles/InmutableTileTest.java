package org.david312.board_lib.tiles;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.david312.board_lib.exceptions.IllegalTileModificationException;

public class InmutableTileTest {
  private InmutableTile<Integer> t;

  @Test
  public void createWithDefaultValue() {
    t = new InmutableTile<>(1);
  }

  @Test
  public void checkValueIsSetWhenPassingParametersToConstructor() {
    t = new InmutableTile<>(1);
    assertTrue(t.isValueSet());
  }

  @Test
  public void checkValueIsNotSetWhenUsingDefaultConstructor() {
    t = new InmutableTile<>();
    assertFalse(t.isValueSet());
  }

  @Test
  public void checkIsValueSetAfterUsingSetMethod() {
    t = new InmutableTile<>();
    t.setValue(0);
    assertTrue(t.isValueSet());
  }

  @Test(expected = IllegalTileModificationException.class)
  public void checkCannotSetValueTwice() {
    t = new InmutableTile<>();
    t.setValue(0);
    t.setValue(0);
  }

  @Test(expected = IllegalTileModificationException.class)
  public void checkCannotSetValueWhenPassingValueInConstructor() {
    t = new InmutableTile<>(0);
    t.setValue(0);
  }


}