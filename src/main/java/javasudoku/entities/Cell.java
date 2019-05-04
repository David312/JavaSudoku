package javasudoku.entities;

public class Cell<T> {
  
  private static final String FORMAT = "[%s]";

  private T value;

  public Cell() {
    this(null);
  }

  public Cell(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format(FORMAT, this.value);
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
      Cell<?> other = (Cell<?>) o;
      return this.value == null ? 
        other.getValue() == null : this.value.equals(other.getValue());
    }
  }
}