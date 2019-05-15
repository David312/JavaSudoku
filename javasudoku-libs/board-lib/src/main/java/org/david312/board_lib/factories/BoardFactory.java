package org.david312.board_lib.factories;

import org.david312.board_lib.boards.Board;

public interface BoardFactory {
  Board getBoard(int rows, int columns);
}
