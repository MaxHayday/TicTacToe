package com.max_hayday.tic_tac_toe;

import java.util.Random;
import java.util.Scanner;


public class GameLogic {
    public static final char CPUCHAR = 'O';
    public static final char PLAYERCHAR = 'Y';
    private Field f;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Using variable flag, we can start looking for a winner.
     */
    private int flag = 0;

    private int min = 1;
    private int max = 9;
    private int cpuPos;
    private int userPos;
    private int variableWitchTelUsWhoIsWin = 1;

    public GameLogic() {
        f = new Field();
    }

    public void run() {
        System.out.println("Welcome to Tic Tac Toe ! ! ! ");
        do {
            f.showField();
            System.out.println("Please choose number from 1 to 9:");
            userPos = getUserInput();
            if (isPosAvailable(userPos, PLAYERCHAR)) {
                flag = f.checkWinner();
                if (flag == 1) break;
                do {
                    cpuPos = getPCInput();
                    if (variableWitchTelUsWhoIsWin == 10) break;
                }
                while (!isPosAvailable(cpuPos, CPUCHAR));
            } else
                System.out.println("Sorry the row is already marked. Choose correct number");
            flag = f.checkWinner();
        } while (flag != 1 && flag != -1);
        f.showField();
        if (flag == 1) {
            if (((variableWitchTelUsWhoIsWin % 2) + 1) == 1)
                System.out.printf("CONGRATULATIONS, YOU WIN ! ! !");
            else
                System.out.println("SORRY, YOU LOSE ( ( ( ");
        } else
            System.out.println("DRAW");
    }

    private int getUserInput() {
        return scanner.nextInt();
    }

    private int getPCInput() {
        return random.nextInt((max - min) + 1) + min;
    }

    private boolean isPosAvailable(int pos, char c) {
        if (f.field[pos] != CPUCHAR && f.field[pos] != PLAYERCHAR) {
            f.save(pos, c);
            variableWitchTelUsWhoIsWin++;
            return true;
        } else {
            return false;
        }
    }
}
