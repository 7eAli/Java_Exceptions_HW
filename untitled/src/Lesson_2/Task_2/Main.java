package Lesson_2.Task_2;
/*
Исправьте код:
    try {
       int d = 0;
       double catchedRes1 = intArray[8] / d;
       System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
       System.out.println("Catching exception: " + e);
    }
 */
public class Main {
    public static void main(String[] args) {
        try {
            int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int d = 0;
            double caughtRes1 = (double) intArray[8] / d;
            System.out.println("caughtRes1 = " + caughtRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
