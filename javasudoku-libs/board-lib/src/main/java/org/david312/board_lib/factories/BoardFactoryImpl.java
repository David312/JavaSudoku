package org.david312.board_lib.factories;

import org.david312.board_lib.boards.Board;
import org.david312.board_lib.boards.BoardImpl;

public class BoardFactoryImpl implements BoardFactory {
  @Override
  public Board getBoard(int rows, int columns) {
    return new BoardImpl(rows, columns, AbstractFactory.getTileFactory());
  }
}
