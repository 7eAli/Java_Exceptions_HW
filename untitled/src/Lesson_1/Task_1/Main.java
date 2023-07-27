package Lesson_1.Task_1;

/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.

    Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива

    Метод divisionByZero - Деление на 0

    Метод numberFormatException - Ошибка преобразования строки в число

Важно: они не должны принимать никаких аргументов
 */

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] numbers = new int[10];
        System.out.println(numbers[10]);
    }

    public static void divisionByZero() {
        System.out.println(10 / 0);
    }

    public static void numberFormatException() {
        String str = "123qw";
        int num = Integer.parseInt(str);
    }
}

public class Main {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
