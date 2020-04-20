package Lesson2;

import java.util.Arrays;

public class Lesson2 {
    static int[] arr = {0,1,0,1,0,0,1,1,0,0,1};
    static int[] arr1 = new int[8];
    static int[] arr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    static int[][] arr3 = new int[5][5];
    static int[] arr4 = {11,2,32,4,54,6,7,8,9};
    static int[] arr5 = {2, 2, 2};
    static int[] arr6 = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        //1
        System.out.println(Arrays.toString(arr));
        reverseNumbers(arr);
        System.out.println(Arrays.toString(arr));
        //2
        fillArray(arr1);
        System.out.println(Arrays.toString(arr1));
        //3
        calculateArray(arr2);
        System.out.println(Arrays.toString(arr2));
        //4
        fillArraysDiagonals(arr3);
        //5
        System.out.println(findArraysBound(arr4));
        //6
        System.out.println(isArraysPartsEquals(arr5));
        //7
        shiftArray(arr6, -1);
        System.out.println(Arrays.toString(arr6));

    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    //С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void reverseNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] > 0 ? 0 : 1;
        }
    }

    //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void calculateArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6) arr[i] *= 2;
        }
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и
    // с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillArraysDiagonals(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }
                if (j == arr.length - i - 1) {
                    arr[i][j] = 1;
                }
                System.out.print("-" + arr[i][j] + "-");
            }
            System.out.println();
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static String findArraysBound(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
        }
        String result = "Максимальное число: " + max + ". Минимальное число: " + min;
        return result;
    }

    //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    // если в массиве есть место, в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean isArraysPartsEquals(int[] arr) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            left += arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                right += arr[j];
            }
            if (left == right) break;
            right = 0;
        }
        return left == right;
    }

    //  7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    // или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения
    // задачи нельзя пользоваться вспомогательными массивами.
    public static void shiftArray(int[] arr, int shift) {
        shift %= arr.length;
        if (shift >= 0) {
            for (int i = 0; i < shift; i++) {
                int a = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr [j - 1] ;
                }
                arr[0] = a;
            }
        } else {
            for (int i = shift; i < 0; i++) {
                int a = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr [j + 1] ;
                }
                arr[arr.length - 1] = a;
            }
        }
    }

}
