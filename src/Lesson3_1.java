import java.util.Random;
import java.util.Scanner;

public class Lesson3_1 {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static final int ATTEMPTS_COUNT = 3;
    public static final int MIN_BOUND = 0;
    public static final int MAX_BOUND = 9;
    public static int failedAttempts = 0;

    public static void main(String[] args) {
        initGame();
    }

    public static void initGame() {
        System.out.println("Число от 0 до 9 загадано");
        int randomNumber = generateRandomNumber();
        System.out.println("У вас есть 3 попытки,чтобы отгадать его!");
        gameCycle(randomNumber);
    }

    public static int generateRandomNumber() {
        return random.nextInt(MAX_BOUND + 1);
    }

    public static boolean checkWin(int randomNumber, int userNumber) {
        if (randomNumber > userNumber) {
            System.out.println("Загаданное число больше");
        }
        if (randomNumber < userNumber) {
            System.out.println("Загаданное число меньше");
        }
        if (randomNumber == userNumber) {
            System.out.println("Победа! Вы угадали!");
        }
        return randomNumber == userNumber;
    }

    public static boolean checkBounds(int userNumber) {
        return userNumber <= MAX_BOUND && userNumber >= MIN_BOUND;
    }

    public static void gameCycle(int randomNumber) {
        for (int i = 0; i < ATTEMPTS_COUNT; i++) {
            System.out.println("Попытка №" + (i + 1) + ". Введите число:");
            int userNumber = scanner.nextInt();
            if (!checkBounds(userNumber)) {
                failedAttempts++;
                if (failedAttempts > 2) {
                    System.out.println("Машины все-таки умнее людей ...");
                }
                System.out.println("Неверное число! Введите число в диапазоне от 0 до 9!");
                i--;
            } else {
                if (checkWin(randomNumber, userNumber)) {
                    failedAttempts = 0;
                    break;
                }
            }
            if (i == ATTEMPTS_COUNT -1) {
                System.out.println("Вы проиграли!");
            }
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int isNeedToRepeat = scanner.nextInt();
        if (isNeedToRepeat == 1) {
            initGame();
        } else {
            System.out.println("Спасибо за игру!");
        }
    }
}
