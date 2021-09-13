package tictactoe;

import java.util.Scanner;

public class PlayingLogic {

    static boolean isGameOver(PlayingTable table) {
        if (!checkIfSomebodyWinAndPrintTable(table)) {
            //check if there is free places
            if (null != table.getFreeCoordinate()) {
                return false;
            } else {
                System.out.println("Draw");
                return true;
            }
        } else {
            System.out.println(table.getWinner() + " wins");
            return true;
        }
    }

    public static boolean validateEnteredData(String[] coordinates, Coordinate coordinate) {
        try {
            coordinate.setXCoordinate(Integer.valueOf(coordinates[0]) - 1);
            coordinate.setYCoordinate(Integer.valueOf(coordinates[1]) - 1);
            return isEnteredNumberAreValid(coordinate) ? true : false;
        } catch (Exception ex) {
            System.out.println("You should enter numbers!");
            return false;
        }
    }

    public static String[] getEnteredCoordinates() {
        System.out.println("Enter the coordinates: >");
        Scanner scanner = new Scanner(System.in);
        String secondStep = scanner.nextLine();
        String[] coordinates = secondStep.split(" ");
        return coordinates;
    }

    private static boolean isEnteredNumberAreValid(Coordinate coordinate) {
        if (!((coordinate.getXCoordinate() == 0 || coordinate.getXCoordinate() == 1 || coordinate.getXCoordinate() == 2) &&
                (coordinate.getYCoordinate() == 0 || coordinate.getYCoordinate() == 1 || coordinate.getYCoordinate() == 2))) {
            System.out.println("Coordinates should be from 1 to 3!");
            return true;
        }
        return false;
    }

    public static boolean checkIfSomebodyWinAndPrintTable(PlayingTable table) {
        table.printInfo();
        return table.hasWinCombination();
    }
}
