package lesson7a;

public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(23);
        Cat[] catsArray = new Cat[]{
                new Cat("Barsik"),
                new Cat("Murzik"),
                new Cat("Chernish"),
                new Cat("Ryzhik")
        };

        for (Cat cat : catsArray) {
            cat.eat(plate);
            plate.info();
            plate.increaseFood(4);
        }


    }
}
