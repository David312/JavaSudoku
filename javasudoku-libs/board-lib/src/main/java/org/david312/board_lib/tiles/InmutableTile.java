package org.david312.board_lib.tiles;


import org.david312.board_lib.exceptions.IllegalTileModificationException;

public class InmutableTile<T> extends NormalTile<T> {

  private boolean valueSet;

  public InmutableTile() {
    super();
    valueSet = false;
  }

  public InmutableTile(T value) {
    super(value);
    valueSet = true;
  }

  public boolean isValueSet() {
    return this.valueSet;
  }

  @Override
  public void setValue(T value) {
    if (isValueSet()) {
      throw new IllegalTileModificationException();
    }
    super.setValue(value);
    this.valueSet = true;
  }

}