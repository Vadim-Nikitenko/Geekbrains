package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    static final int SIZE = 5;
    static final int DOTS_TO_WIN = 4;
    static int level = 1;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Ты Супер победитель!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья...");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O, DOTS_TO_WIN)) {
                System.out.println("ИИ нынче очень развито, компьютер победил!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья...");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%s ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("input koord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;

    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x;
        int y;
        checkAIWin();
        if (!checkHumanWin()) {
            do {
                y = random.nextInt(SIZE);
                x = random.nextInt(SIZE);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;
        }
    }

    // ****************** ДОМАШНЕЕ ЗАДАНИЕ ****************
    private static boolean checkWin(char c, int dotToWin) {
        for (int i = 0; i < SIZE; i++) {            // ползём по всему полю
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 1, 0, dotToWin, c)) return true;
                if (checkLine(i, j, 1, 1, dotToWin, c)) return true;
                if (checkLine(i, j, 0, 1, dotToWin, c)) return true;
                if (checkLine(i, j, 1, -1, dotToWin, c)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int x, int y, int h1, int h2, int dotToWIn, char c) {
        final int endLine_x = x + (dotToWIn - 1) * h1;
        final int endLine_y = y + (dotToWIn - 1) * h2;
        if (endLine_x < 0 || endLine_y < 0 || endLine_x >= SIZE || endLine_y >= SIZE) return false;
        for (int i = 0; i < dotToWIn; i++) {
            if (map[y + i * h2][x + i * h1] != c) return false;
        }
        return true;
    }

    private static void checkAIWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN)) return;
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
    }

    private static boolean checkHumanWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, DOTS_TO_WIN - level)) {
                        map[i][j] = DOT_O;
                        level = 0;
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }
}