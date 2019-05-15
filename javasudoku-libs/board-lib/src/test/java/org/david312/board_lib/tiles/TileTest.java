package org.david312.board_lib.tiles;

import org.david312.board_lib.factories.AbstractFactory;
import org.david312.board_lib.factories.TileFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

  private final TileFactory tileFactory = AbstractFactory.getTileFactory();
  private final Integer defaultValue = 1;

  private Tile<Integer> tileWithNoValue;
  private Tile<Integer> tileWithValue;

  @Before
  public void setup() {
    tileWithNoValue = tileFactory.getTile(TileType.NORMAL);
    tileWithValue = tileFactory.getTile(TileType.NORMAL);
    tileWithValue.setValue(defaultValue);
  }

  @Test
  public void checkTileWithunassignedValue() {
    assertNull(tileWithNoValue.getValue());
  }

  @Test
  public void checkTileWithValue() {
    assertEquals(defaultValue, tileWithValue.getValue());
  }

  @Test
  public void checkSetTileValue() {
    tileWithNoValue.setValue(defaultValue);
    assertEquals(defaultValue, tileWithNoValue.getValue());
  }

  @Test
  public void equalsWithNull() {
    assertFalse(tileWithNoValue.equals(null));
  }

  @Test
  public void equalsWithNonInstanceOfCell() {
    assertFalse(tileWithNoValue.equals(new Object()));
  }

  @Test
  public void equalsWithSelf() {
    assertTrue(tileWithNoValue.equals(tileWithNoValue));
  }

  @Test
  public void equalsWithOtherWithSameNullValue() {
    Tile<Integer> other = tileFactory.getTile(TileType.NORMAL);
    assertTrue(tileWithNoValue.equals(other));
  }

  @Test
  public void notEqualsWithOtherWithNonNullValue() {
    assertFalse(tileWithNoValue.equals(tileWithValue));
  }

  @Test
  public void equalsWithNonNullValues() {
    Tile<Integer> other = tileFactory.getTile(TileType.NORMAL);
    other.setValue(defaultValue);
    assertTrue(tileWithValue.equals(other));
  }
}
