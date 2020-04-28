package lesson7_1;

public class Cat {
    String name;
    final int APPETITE = 10;
    private boolean isFull;

    public Cat(String name) {
        this.name = name;
        this.isFull = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() > APPETITE) {
            System.out.println("Cat " + name + " eat...");
            plate.decreaseFood(APPETITE);
            setFull(true);
            System.out.println("Is " + name + " full? - " + isFull);
        } else {
            System.out.println(name + " wanna eat..." + " But there is not enough meal in the plate to make him full... ");
        }
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
