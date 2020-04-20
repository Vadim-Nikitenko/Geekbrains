package Lesson1;

public class Lesson1 {
    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    private byte b = 1;
    private int i = 10;
    private short s = 100;
    private long l = 1000L;
    private float f = 1.5f;
    private double d = 1.5;
    private char ch = 65;
    private boolean bool = true;
    private String str = "Hello world";

    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        System.out.println(calculate(1, 2, 3, 4));
        System.out.println(compare(15, 1));
        checkSign(-4);
        System.out.println(checkNumber(5));
        printName("Фанзиль");
        checkYear(4);
        checkYear(100);
        checkYear(400);
        checkYear(1203);
    }

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    // где a, b, c, d – входные параметры этого метода;
    public static int calculate(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
    // пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean compare(int a, int b) {
        return (a + b) >= 10 && (a + b) <= 20;
    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
    // в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    public static void checkSign(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен
    // вернуть true, если число отрицательное;
    public static boolean checkNumber(int a) {
        return a < 0;
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void printName(String str) {
        System.out.println("Привет, " + str + "!");
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение
    // в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static void checkYear(int year) {
        if ( year % 4 == 0 && year % 100 != 0 ^ year % 400 == 0) {
            System.out.println(year + " - это високосный год");
        } else {
            System.out.println(year + " - это не високосный год");
        }
    }

}
