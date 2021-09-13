package tictactoe.players;

import tictactoe.Coordinate;
import tictactoe.PlayingLogic;
import tictactoe.PlayingTable;

public class UserPlayer implements Play {
    @Override
    public void makeStep(PlayingTable table, String userMoveSymbol) {
        while (true) {
            String[] coordinates = PlayingLogic.getEnteredCoordinates();
            Coordinate newCoordinate = new Coordinate();
            if (PlayingLogic.validateEnteredData(coordinates, newCoordinate)) continue;
            if (table.isCellFree(table.getTable(), newCoordinate.getXCoordinate(), newCoordinate.getYCoordinate())) {
                table.getTable()[newCoordinate.getXCoordinate()][newCoordinate.getYCoordinate()] = userMoveSymbol;
                System.out.println("Making move level \"easy\"");
                break;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
        }
    }
}
