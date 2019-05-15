package org.david312.board_lib.factories;

public class AbstractFactory {
  public static TileFactory getTileFactory() {
    return new TileFactoryImpl();
  }

  public static BoardFactory getBoardFactory() {
    return new BoardFactoryImpl();
  }

  private AbstractFactory(){}
}
