package tictactoe.players;

import tictactoe.Coordinate;
import tictactoe.PlayingTable;

public class HardComputerPlayer extends ComputerPlayer {

    @Override
    public void makeStep(PlayingTable table, String playerMoveSymbol) {
        String anotherPlayerMoveSymbol = playerMoveSymbol.equals("X") ? "O" : "X";
        int bestScore = -10000;
        Coordinate bestMove = new Coordinate();

        for (int i = 0; i < table.getTableSize(); i++) {
            for (int j = 0; j < table.getTableSize(); j++) {
                if (table.isCellFree(table.getTable(), i, j)) {
                    table.getTable()[i][j] = playerMoveSymbol;
                    table.setCurrentAIPlayer(playerMoveSymbol);
                    int score = minimax(table, 0, false, anotherPlayerMoveSymbol);
                    table.getTable()[i][j] = "_";
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove.setXCoordinate(i);
                        bestMove.setYCoordinate(j);
                    }
                }
            }
        }
        table.getTable()[bestMove.getXCoordinate()][bestMove.getYCoordinate()] = playerMoveSymbol;
        System.out.println("Making move level \"hard\"");
    }

    private int minimax(PlayingTable table, int depth, boolean isMaximize, String playerMoveSymbol) {
        String anotherPlayerMoveSymbol = playerMoveSymbol.equals("X") ? "O" : "X";

        if (table.hasWinCombination() || table.getFreeCoordinates().isEmpty()) {
            return getScore(table, depth);
        }

        if (isMaximize) {
            int bestScore = -10000;
            for (int i = 0; i < table.getTableSize(); i++) {
                for (int j = 0; j < table.getTableSize(); j++) {
                    if (table.isCellFree(table.getTable(), i, j)) {
                        table.getTable()[i][j] = playerMoveSymbol;
                        int score = minimax(table, depth + 1, false, anotherPlayerMoveSymbol);
                        table.getTable()[i][j] = "_";
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 10000;
            for (int i = 0; i < table.getTableSize(); i++) {
                for (int j = 0; j < table.getTableSize(); j++) {
                    if (table.isCellFree(table.getTable(), i, j)) {
                        table.getTable()[i][j] = playerMoveSymbol;
                        int score = minimax(table, depth + 1, true, anotherPlayerMoveSymbol);
                        table.getTable()[i][j] = "_";
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    private int getScore(PlayingTable table, int depth) {
        if (null == table.getWinner()) {
            return 0;
        } else if (table.getWinner().equals(table.getCurrentAIPlayer())) {
            table.setWinner(null);
            return +10 - depth;
        } else {
            table.setWinner(null);
            return -10 + depth;
        }
    }
}
