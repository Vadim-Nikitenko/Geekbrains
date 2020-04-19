import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3_2 {
    public static String[] words = {
            "apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
    };
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static StringBuilder help = new StringBuilder();
    public static int attemptsCount = 1;
    public static String userWord;
    public static String randomWord;
    public static final int WORD_LENGTH = 15;

    public static void main(String[] args) {
        initGame();
    }

    public static void initGame() {
        System.out.println("Начинаем игру \"Угадай слово\"\nКомпьютер случайным образом загадал одно слово");
        System.out.println("Список слов:" + Arrays.toString(words));
        randomWord = computerImagineWord();
        gameCycle();
    } 

    public static String computerImagineWord() {
        return words[random.nextInt(words.length)];
    }

    public static void gameCycle() {
        do {
            System.out.println("Попытка №" + (attemptsCount++) + ". Угадайте слово:");
            userWord = scanner.nextLine().toLowerCase();
            if (randomWord.equals(userWord)) {
                System.out.println("Вы победили! Спасибо за игру!");
            } else {
                System.out.println("Вы не угадали!");
                compareWords();
                System.out.println("Подсказка: " + help);
                help.setLength(0);
            }
        } while (!checkWin(randomWord,userWord));
    }

    private static boolean checkWin(String randomWord, String userWord) {
        return randomWord.equals(userWord);
    } 

    public static void compareWords() {
        int min = 0;
        min = Math.min(randomWord.length(), userWord.length());
        for (int i = 0; i < min; i++) {
            if (userWord.charAt(i) == randomWord.charAt(i)) {
             help.append(userWord.charAt(i));
            } else {
                help.append("#");
            }
            if(i == min -1) {
                for (int j = 0; j < WORD_LENGTH - min; j++) {
                    help.append("#");
                }
            }
        }
    }
}
