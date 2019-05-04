package javasudoku.entities;

import javasudoku.exceptions.InmutableCellModificationException;

public class InmutableCell<T> extends Cell<T> {

  private boolean valueSet = false;

  public InmutableCell() {
    super();
    valueSet = false;
  }

  public InmutableCell(T value) {
    super(value);
    valueSet = true;
  }

  public boolean isValueSet() {
    return this.valueSet;
  }

  @Override
  public void setValue(T value) {
    if (isValueSet()) {
      throw new InmutableCellModificationException();
    }
    super.setValue(value);
    this.valueSet = true;
  }

}