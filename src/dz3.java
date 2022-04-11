import java.util.Arrays;

import static java.lang.Math.abs;

public class dz3 {
    public static void main(String[] args) {

        //Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
        //0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }

        // Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
        //значениями 1 2 3 4 5 6 7 8 … 100;
        int[] array1 = new int[100];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1;
        }

        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
        //умножить на 2;
        int[] array2 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] < 6) array1[i] *= 2;
        }

        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов
        //одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        //(можно только одну из диагоналей, если обе сложно). Определить элементы одной из
        //диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0],
        //[1][1], [2][2], …, [n][n];
        int dimension = 9;
        int[][] array3 = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            array3[i][i] = 1;
            array3[dimension - i - 1][i] = 1;
        }
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(array3[i][j] + " ");
            }
            System.out.println();
        }

        //Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
        //одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        int len = 20, initialValue = 5;
        int[] array4 = initArray(len, initialValue);
        for (int i = 0; i < array4.length; i++) {
            System.out.print(array4[i] + " ");
        }
        System.out.println();

        //Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        int[] array5 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = array5[0], max = min; //
        for (int i = 0; i < array5.length; i++) {
            for (int j = 0; j < array5.length; j++) {
                if (min > array5[i]) min = array5[i];
                if (max < array5[i]) max = array5[i];
            }
        }
        for (int i = 0; i < array5.length; i++) {
            System.out.print(array5[i] + " ");
        }
        System.out.println("min=" + min + ", max=" + max);

        //** Написать метод, в который передается не пустой одномерный целочисленный массив,
        //метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
        //массива равны.
        //Примеры:
        //checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
        //checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
        //граница показана символами |||, эти символы в массив не входят и не имеют никакого
        //отношения к ИЛИ.
        int[] array6 = new int[]{1, 2, 3, 4, 10};
        checkBalance(array6);


        //*** Написать метод, которому на вход подается одномерный массив и число n (может быть
        //положительным, или отрицательным), при этом метод должен сместить все элементы массива
        //на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
        //вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5,
        //6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете
        //выбирать сами.
        int n = -11;
        int[] array7 = new int[]{1, 2, 3, 4, 10};
        rotateInArray(array7, n);
    }

    private static int[] initArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    private static boolean checkBalance(int[] array) {
        if (array == null || array.length == 1) return false;

        for (int i = 1; i < array.length; i++) {
            int leftHand = 0, rightHand = 0;
            for (int step = 0; step < i; step++) {
                leftHand += array[step];
                System.out.println("i=" + i + " leftHand=" + leftHand);
            }
            for (int step = i; step < array.length; step++) {
                rightHand += array[step];
                System.out.println("i=" + i + " rightHand=" + rightHand);
            }
            if (leftHand == rightHand) return true;
        }
        return false;
    }

    private static void rotateInArray(int[] array, int n) {
        if (n == 0 || array == null || array.length == 1) return;
        int temp;
        int len = array.length;
        int offset = abs(n % len);

        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        if (n < 0) {
            for (int i = 0; i < offset; i++) {
                temp = array[0];
                for (int j = 0; j < len-1; j++) {
                    array[j] = array[j + 1];
                }
                array[len - 1] = temp;
            }
        } else {
            for (int i = 0; i < offset; i++) {
                temp = array[len - 1];
                for (int j = len - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
