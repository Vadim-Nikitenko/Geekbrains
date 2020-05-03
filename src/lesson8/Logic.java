package lesson8;


import java.util.Random;

public class Logic {
    static int SIZE_X;
    static int SIZE_Y;
    static int DOTS_TO_WIN;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';
    static final int DIFFICULT = 2;
    static int level = 2;
    static int gameMode;

    static char[][] map;
    static Random random = new Random();
    static boolean gameFinished = false;

    public static void go() {
        gameFinished = true;
        if (checkWin(DOT_X, DOTS_TO_WIN) && gameMode == 0) {
            WinnerWindow.setText("Ты победил!");
            level = DIFFICULT;
            return;
        }
        if (checkWin(DOT_X, DOTS_TO_WIN) && gameMode == 1) {
            WinnerWindow.setText("Крестики победили");
            return;
        }

        if (isFull()) {
            WinnerWindow.setText("Ничья");
            level = DIFFICULT;
            return;
        }
        if (gameMode == 0) {
            aiTurn();
        }
        if (checkWin(DOT_O, DOTS_TO_WIN) && gameMode == 0) {
            WinnerWindow.setText("Компьютер победил");
            level = DIFFICULT;
            return;
        }
        if (checkWin(DOT_O, DOTS_TO_WIN) && gameMode == 1) {
            WinnerWindow.setText("Нолики победили");
            return;
        }
        if (isFull()) {
            WinnerWindow.setText("Ничья");
            level = DIFFICULT;
            return;
        }
        gameFinished = false;
    }

    public static void initMap() {
        map = new char[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void setHuman1XY(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();
        }
    }

    public static void setHuman2XY(int x, int y) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_O;
            go();
        }
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE_X || y >= SIZE_Y) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x;
        int y;
        checkAIWin();
        if (!checkHumanWin()) {
            do {
                y = random.nextInt(SIZE_Y);
                x = random.nextInt(SIZE_X);
            } while (!isCellValid(y, x));
            map[y][x] = DOT_O;
        }
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }


    //
    private static boolean checkWin(char c, int dotToWin) {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (checkLine(i, j, 1, 0, dotToWin, c)) return true;
                if (checkLine(i, j, 1, 1, dotToWin, c)) return true;
                if (checkLine(i, j, 0, 1, dotToWin, c)) return true;
                if (checkLine(i, j, 1, -1, dotToWin, c)) return true;
            }
        }
        return false;
    }

    public static boolean checkLine(int x, int y, int h1, int h2, int dotToWIn, char c) {
        final int endLine_x = x + (dotToWIn - 1) * h1;
        final int endLine_y = y + (dotToWIn - 1) * h2;
        if (endLine_x < 0 || endLine_y < 0 || endLine_x >= SIZE_X || endLine_y >= SIZE_Y) return false;
        for (int i = 0; i < dotToWIn; i++) {
            if (map[y + i * h2][x + i * h1] != c) return false;
        }
        return true;
    }

    private static void checkAIWin() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN)) return;
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
    }

    private static boolean checkHumanWin() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, DOTS_TO_WIN - level)) {
                        map[i][j] = DOT_O;
                        if(level > 0){
                            level--;
                        }
                        return true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        return false;
    }

    public static void setGameMode(int gameMode) {
        Logic.gameMode = gameMode;
    }

}
