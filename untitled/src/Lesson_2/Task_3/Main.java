package Lesson_2.Task_3;

/*
Исправьте код:
    public static void main(String[] args) throws Exception {
       try {
           int a = 90;
           int b = 3;
           System.out.println(a / b);
           printSum(23, 234);
           int[] abc = { 1, 2 };
           abc[3] = 9;
       } catch (Throwable ex) {
           System.out.println("Что-то пошло не так...");
       } catch (NullPointerException ex) {
           System.out.println("Указатель не может указывать на null!");
       } catch (IndexOutOfBoundsException ex) {
           System.out.println("Массив выходит за пределы своего размера!");
       }
    }
    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
       System.out.println(a + b);
    }
 */

public class Main {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 1;
            System.out.println(a / b);
            printSum(23, 12);
            int[] abc = { 1, 2 };
            for (int i = 0; i < abc.length; i++) {
                System.out.println(abc[i]);
            }
        } catch (NullPointerException e) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (ArithmeticException e) {
            System.out.println("На ноль делить нельзя");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
