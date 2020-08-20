package com.max_hayday.tic_tac_toe;

public class Field {
    protected char[] field;

    Field() {
        field = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void showField() {
        System.out.printf("%c|%c|%c \n", field[1], field[2], field[3]);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c \n", field[4], field[5], field[6]);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c \n", field[7], field[8], field[9]);
    }

    public void save(int pos, char a) {
            field[pos] = a;
    }

    public int checkWinner() {
        if (field[1] == field[2] && field[2] == field[3])
            return 1;
        else if (field[4] == field[5] && field[5] == field[6])
            return 1;
        else if (field[7] == field[8] && field[8] == field[9])
            return 1;
        else if (field[1] == field[4] && field[4] == field[7])
            return 1;
        else if (field[2] == field[5] && field[5] == field[8])
            return 1;
        else if (field[3] == field[6] && field[6] == field[9])
            return 1;
        else if (field[1] == field[5] && field[5] == field[9])
            return 1;
        else if (field[3] == field[5] && field[5] == field[7])
            return 1;
        else if (field[1] != '1' && field[2] != '2' && field[3] != '3' && field[4] != '4' && field[5]
                != '5' && field[6] != '6' && field[7] != '7' && field[8] != '8' && field[9] != '9')
            return -1;
        else return 0;
    }
}