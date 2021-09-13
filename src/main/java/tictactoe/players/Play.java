package tictactoe.players;

import tictactoe.PlayingTable;

public interface Play {
    void makeStep(PlayingTable table, String userMoveSymbol);
}
