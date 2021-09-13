package tictactoe;

import tictactoe.players.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Play firstPlayer;
        Play secondPlayer;

        while (true) {
            String[] command = getEnteredCommand().split(" ");
            if (command[0].equals("exit")) {
                break;
            } else if (command.length == 3) {
                if (command[0].equals("start")) {
                    if (command[1].equals("user")) {
                        firstPlayer = new UserPlayer();
                    } else if (command[1].equals("easy")) {
                        firstPlayer = new EasyComputerPlayer();
                    } else if(command[1].equals("medium")) {
                        firstPlayer = new MediumComputerPlayer();
                    } else if(command[1].equals("hard")) {
                        firstPlayer = new HardComputerPlayer();
                    } else {
                        continue;
                    }
                    //second player
                    if (command[2].equals("user")) {
                        secondPlayer = new UserPlayer();
                        play(firstPlayer, secondPlayer);
                        break;
                    } else if (command[2].equals("easy")) {
                        secondPlayer = new EasyComputerPlayer();
                        play(firstPlayer, secondPlayer);
                        break;
                    }else if(command[2].equals("medium")) {
                        secondPlayer = new MediumComputerPlayer();
                        play(firstPlayer, secondPlayer);
                        break;
                    } else if(command[2].equals("hard")) {
                        secondPlayer = new HardComputerPlayer();
                        play(firstPlayer, secondPlayer);
                        break;
                    } else {
                        continue;
                    }
                }
            } else {
                System.out.println("Bad parameters!");
                continue;
            }
        }
    }

    private static String getEnteredCommand() {
        System.out.print("Input command: >");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void play(Play player1, Play player2){
        PlayingTable table = new PlayingTable();
        table.printInfo();
        String firstPlayerSymbol = "X";
        String secondPlayerSymbol = "O";

        while (true) {
            player1.makeStep(table, firstPlayerSymbol );
            if (PlayingLogic.isGameOver(table)) {
                break;
            }

            player2.makeStep(table, secondPlayerSymbol );
            if (PlayingLogic.isGameOver(table)){
                break;
            }
        }
    }
}
