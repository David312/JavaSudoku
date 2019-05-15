package org.david312.board_lib.tiles;


public class NormalTile<T> implements Tile<T>{

  private T value;

  public NormalTile() {
    this(null);
  }

  public NormalTile(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  @Override
  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if(!(o instanceof Tile)) {
      return false;
    }
    else if (o == this) {
      return true;
    }
    else {
      Tile<T> other = (Tile<T>) o;
      return this.value == null ? other.getValue() == null : this.value.equals(other.getValue());
    }
  }

}