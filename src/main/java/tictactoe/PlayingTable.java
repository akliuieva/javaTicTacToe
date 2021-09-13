package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayingTable {
    private String[][] table;
    private int tableSize;
    private String currentAIPlayer;
    private String winner;

    public String getCurrentAIPlayer() {
        return currentAIPlayer;
    }

    public void setCurrentAIPlayer(String currentAIPlayer) {
        this.currentAIPlayer = currentAIPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
       this.winner = winner;
    }

    public PlayingTable() {
        this.tableSize = 3;

        table = new String[tableSize][tableSize];
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                table[i][j] = "_";
            }
        }
    }

    public String[][] getTable() {
        return table;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void printInfo() {
        System.out.println("---------");
        for (int i = 0; i < table.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < table.length; j++) {
                if (table[i][j].equals("_")) {
                    System.out.print("  ");
                } else {
                    System.out.print(table[i][j] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public boolean isRowWithEqualSymbolExist() {
        for (int i = 0; i < getTableSize(); i++) {
            if (table[i][0].equals(table[i][1]) && table[i][0].equals(table[i][2])
                    && !(table[i][0].equals("_"))) {
                if (table[i][0].equals("X")) {
                    setWinner("X");
                } else {
                    setWinner("O");
                }
                return true;
            }
        }
        return false;
    }

    public boolean isColumnWithEqualSymbolExist() {
        for (int i = 0; i < getTableSize(); i++) {
            if (table[0][i].equals(table[1][i]) && table[0][i].equals(table[2][i])
                    && !(table[0][i].equals("_"))) {
                if (table[0][i].equals("X")) {
                    setWinner("X");
                } else {
                    setWinner("O");
                }
                return true;
            }
        }
        return false;
    }

    public boolean isFirstDiagonalContainSameSymbol() {
        int i = 0;
        if (table[i][i].equals(table[i + 1][i + 1]) && table[i][i].equals(table[i + 2][i + 2])
                && !(table[i][i].equals("_"))) {
            if (table[i][0].equals("X")) {
                setWinner("X");
            } else {
                setWinner("O");
            }
            return true;
        }
        return false;
    }

    public boolean isSecondDiagonalContainSameSymbol() {
        int i = 2;
        if (table[i - 2][i].equals(table[i - 1][i - 1]) && table[i - 2][i].equals(table[i][i - 2])
                && !(table[i - 2][i].equals("_"))) {
            if (table[i - 2][i].equals("X")) {
                setWinner("X");
            } else {
                setWinner("O");
            }
            return true;
        }
        return false;
    }

    public List<Coordinate> getFreeCoordinates() {
        List<Coordinate> listWithFreePlaces = new ArrayList();

        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (isCellFree(table, i, j)) {
                    listWithFreePlaces.add(new Coordinate(i, j));
                }
            }
        }
        return listWithFreePlaces;
    }

    public Coordinate getFreeCoordinate() {
        List<Coordinate> listWithFreeSpots = getFreeCoordinates();

        if (!listWithFreeSpots.isEmpty()) {
            Random random = new Random();
            int randomCoordinate = random.nextInt(listWithFreeSpots.size());
            return listWithFreeSpots.get(randomCoordinate);
        } else {
            return null;
        }
    }

    public boolean isCellFree(String[][] twoDimArray, int xCoordinate, int yCoordinate) {
        if (twoDimArray[xCoordinate][yCoordinate].equals("_")) {
            return true;
        }
        return false;
    }

    public boolean verifyIfRowContainFreeIconAndPlayerCanWin(String playerMoveSymbol) {
        for (int i = 0; i < getTableSize(); i++) {
            if (table[i][0].equals(table[i][1]) && !(table[i][0].equals("_")) && table[i][2].equals("_")) {
                table[i][2] = playerMoveSymbol;
                return true;
            } else if (table[i][1].equals(table[i][2]) && !(table[i][1].equals("_")) && table[i][0].equals("_")) {
                table[i][0] = playerMoveSymbol;
                return true;
            } else if (table[i][0].equals(table[i][2]) && !(table[i][0].equals("_")) && table[i][1].equals("_")) {
                table[i][1] = playerMoveSymbol;
                return true;
            }
        }
        return false;
    }

    public boolean verifyIfColumnContainFreeIconAndPlayerCanWin(String playerMoveSymbol) {
        for (int i = 0; i < getTableSize(); i++) {
            if (table[0][i].equals(table[1][i]) && !(table[0][i].equals("_")) && table[2][i].equals("_")) {
                table[2][i] = playerMoveSymbol;
                return true;
            } else if (table[1][i].equals(table[2][i]) && !(table[1][i].equals("_")) && table[0][i].equals("_")) {
                table[0][i] = playerMoveSymbol;
                return true;
            } else if (table[0][i].equals(table[2][i]) && !(table[0][i].equals("_")) && table[1][i].equals("_")) {
                table[1][i] = playerMoveSymbol;
                return true;
            }
        }
        return false;
    }

    public boolean verifyIfFirstDiagonalContainFreeIconAndPlayerCanWin(String playerMoveSymbol) {
        int i = 0;
        if (table[i][i].equals(table[i + 1][i + 1]) && !(table[i][i].equals("_")) && table[i + 2][i + 2].equals("_")) {
            table[i + 2][i + 2] = playerMoveSymbol;
            return true;
        } else if (table[i][i].equals(table[i + 2][i + 2]) && !(table[i][i].equals("_")) && table[i + 1][i + 1].equals("_")) {
            table[i + 1][i + 1] = playerMoveSymbol;
            return true;
        } else if (table[i + 1][i + 1].equals(table[i + 2][i + 2]) && !(table[i+1][i+1].equals("_")) && table[i][i].equals("_")) {
            table[i][i] = playerMoveSymbol;
            return true;
        }
        return false;
    }

    public boolean verifyIfSecondDiagonalContainFreeIconAndPlayerCanWin(String playerMoveSymbol) {
        int i = 2;
        if (table[i - 2][i].equals(table[i - 1][i - 1]) && !(table[i-2][i].equals("_")) && table[i][i - 2].equals("_")) {
            table[i][i - 2] = playerMoveSymbol;
            return true;
        } else if (table[i - 2][i].equals(table[i][i - 2]) && !(table[i-1][i].equals("_")) &&  table[i - 1][i - 1].equals("_")) {
            table[i - 1][i - 1] = playerMoveSymbol;
            return true;
        } else if ((table[i - 1][i - 1]).equals(table[i][i - 2]) && !(table[i-1][i-1].equals("_")) && table[i - 2][i].equals("_")) {
            table[i - 2][i] = playerMoveSymbol;
            return true;
        }
        return false;
    }

    public boolean hasWinCombination() {
        return isRowWithEqualSymbolExist() || isColumnWithEqualSymbolExist()
                || isFirstDiagonalContainSameSymbol() || isSecondDiagonalContainSameSymbol();
    }
}
