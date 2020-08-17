package com.max_hayday.tic_tac_toe;

import java.util.Random;
import java.util.Scanner;

import static com.max_hayday.tic_tac_toe.Field.CPUCHAR;
import static com.max_hayday.tic_tac_toe.Field.PLAYERCHAR;

public class GameLogic {

    private Field f;
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private int flag = 0;
    private int min = 1;
    private int max = 9;
    private int cpuPos;
    private int player = 1;

    public GameLogic() {
        f = new Field();
    }

    public void run() {
        System.out.println("Welcome to Tic Tac Toe ! ! ! ");
        do {
            f.showField();
            System.out.println("Please choose number from 1 to 9:");
            int pos = scanner.nextInt();
            cpuPos = random.nextInt((max - min) + 1) + min;
            if (isPosAvailable(pos)) {
                f.save(pos, PLAYERCHAR);
                player++;
                flag = f.checkWinner();
                if (flag == 1) break;
                do {
                    cpuPos = random.nextInt((max - min) + 1) + min;
                    if (player == 10) break;
                }
                while (!isPosAvailable(cpuPos));
                f.save(cpuPos, CPUCHAR);
                player++;
            } else
                System.out.println("Sorry the row is already marked. Choose correct number");
            flag = f.checkWinner();
        } while (flag != 1 && flag != -1);
        f.showField();
        if (flag == 1) {
            if (((player % 2) + 1) == 1)
                System.out.printf("CONGRATULATIONS, YOU WIN ! ! !");

            else
                System.out.println("SORRY, TOU LOSE ( ( ( ");
        } else
            System.out.println("DRAW");
    }

    public boolean isPosAvailable(int pos) {
        if (f.field[pos] != CPUCHAR && f.field[pos] != PLAYERCHAR)
            return true;
        else return false;
    }
}
