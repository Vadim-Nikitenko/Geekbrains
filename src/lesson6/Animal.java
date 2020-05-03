package lesson6;

import java.util.Random;

public class Animal {
    private float maxRun;
    private float maxJump;
    private float maxSwim;
    private static int count;
    Random random = new Random();

    public Animal(float maxRun, float maxJump, float maxSwim) {
        this.maxRun = maxRun + (random.nextFloat() * maxRun / 2 - maxRun / 4);
        this.maxJump = maxJump + (random.nextFloat() * maxJump / 2 - maxJump / 4);
        this.maxSwim = maxSwim + (random.nextFloat() * maxSwim / 2 - maxSwim / 4);
        count = ++count;
    }

    public void run(float length) {
        System.out.println("Могу пробежать: " + maxRun);
        System.out.println("Run: " + (length <= maxRun));
    }

    public void jump(float length) {
        System.out.println("Могу прыгнуть: " + maxJump);
        System.out.println("Jump: " + (length <= maxJump));
    }

    public void swim(float length) {
        System.out.println("Могу проплыть: " + maxSwim);
        System.out.println("Swim: " + (length <= maxSwim));
    }

    public static int getCount() {
        return count;
    }

}
