package Lesson6;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.run(222);
        cat.jump(1);
        cat.swim(2);

        dog.run(200);
        dog.jump(6);
        dog.swim(5);

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCountCat());
        System.out.println(Dog.getCountDog());
    }
}
