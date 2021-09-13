package tictactoe.players;

import tictactoe.Coordinate;
import tictactoe.PlayingTable;

import java.util.Random;

public class MediumComputerPlayer extends ComputerPlayer{
    @Override
    public void makeStep(PlayingTable table, String playerMoveSymbol) {
        if(!checkIfWinnerFlowExist(table, playerMoveSymbol)){
            Coordinate coordinate = table.getFreeCoordinate();
            table.getTable()[coordinate.getXCoordinate()][coordinate.getYCoordinate()] = playerMoveSymbol;
        }
        System.out.println("Making move level \"medium\"");
    }

    private boolean checkIfWinnerFlowExist(PlayingTable table, String playerMoveSymbol) {

        Random random = new Random();
        int randomNumber = random.nextInt(4);

        if(randomNumber == 0){
            return table.verifyIfRowContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfColumnContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfFirstDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfSecondDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol);
        } else if(randomNumber == 1){
            return table.verifyIfColumnContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfRowContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfFirstDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfSecondDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol);
        } else if(randomNumber == 2){
            return table.verifyIfFirstDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfRowContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfColumnContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfSecondDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol);
        } else if(randomNumber == 3){
            return table.verifyIfSecondDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfRowContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfColumnContainFreeIconAndPlayerCanWin(playerMoveSymbol) ||
                    table.verifyIfFirstDiagonalContainFreeIconAndPlayerCanWin(playerMoveSymbol);
        }
        return false;
    }
}
