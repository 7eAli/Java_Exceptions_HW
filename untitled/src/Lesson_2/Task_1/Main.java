package Lesson_2.Task_1;

/*
    Реализуйте метод, который запрашивает у пользователя ввод дробного
числа (типа float), и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat(){
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Введите десятичную дробь");
        String number = scanner.nextLine();
        float result = 0;
        boolean flag = true;
        while (flag) {
            if (number.matches("[0-9]+.+[0-9]")) {
                result = Float.parseFloat(number);
                flag = false;
            }
            else {
                System.out.println("Неправильный ввод, повторите попытку");
                number = scanner.nextLine();
            }
        }
        return result;
    }
}
