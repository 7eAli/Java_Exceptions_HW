package Lesson_2.Task_4;

/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String str = scanner.nextLine();
        if (str.equals("")) {
            throw new RuntimeException("Нельзя вводить пустую строку");
        }
        else System.out.println(str);
    }
}
