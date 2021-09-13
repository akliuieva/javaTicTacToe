package tictactoe.players;

import tictactoe.Coordinate;
import tictactoe.PlayingTable;

public class EasyComputerPlayer extends ComputerPlayer{

    @Override
    public void makeStep(PlayingTable table, String computerMoveSymbol) {
        Coordinate coordinate = table.getFreeCoordinate();
        table.getTable()[coordinate.getXCoordinate()][coordinate.getYCoordinate()] = computerMoveSymbol;
        System.out.println("Making move level \"easy\"");
    }
}
