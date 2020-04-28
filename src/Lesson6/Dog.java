package Lesson6;

public class Dog extends Animal {
    private static int countDog;

    public Dog() {
        super(500, 0.5f, 10);
        countDog = ++countDog;
    }

    public static int getCountDog() {
        return countDog;
    }
}
