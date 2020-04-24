package Lesson6;

public class Cat extends Animal {
    private static int countCat;

    public Cat() {
        super(200, 2, 0);
    }

    @Override
    public void swim(float length) {
        System.out.println("Коты не умеют плавать");
        countCat = ++countCat;
    }

    public static int getCountCat() {
        return countCat;
    }

}
