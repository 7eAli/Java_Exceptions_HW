package Lesson_3.Task_Final;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
в него в одну строку должны записаться полученные данные, вида:
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */

public class Main {
    public static void main(String[] args) {
        try {
            int exit = 0;
            while (exit != 1) {
                exit = input();
            }
        } catch (StringFormatException | DateException | PhoneException | GenderException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int input() throws DateException, GenderException, PhoneException, StringFormatException{
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        inputMessage();
        String inputString = scanner.nextLine();
        if (inputString.equals("exit")) return 1;
        String[] parsedString = inputString.split(" ");
        checkStringFormat(parsedString);
        String[] date = parsedString[3].split("\\.");
        checkDate(date);
        checkPhoneNumber(parsedString[4]);
        checkGender(parsedString[5]);
        saveFile(parsedString[0], parsedString);
        return 0;
    }
    public static void saveFile(String filePath, String[] parsedString) {
        try (FileWriter fileWriter = new FileWriter(filePath + ".txt", true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (String s : parsedString) {
                bufferedWriter.write(s);
                bufferedWriter.write(" ");
            }
            bufferedWriter.write("\n");
        } catch (IOException e) {
            System.out.println("Недопустимое имя файла");
        }
    }

    public static void inputMessage(){
        System.out.println("Введите данные через пробел в формате:");
        System.out.println("фамилия, имя, отчество - строки");
        System.out.println("дата рождения - строка формата dd.mm.yyyy");
        System.out.println("номер телефона - целое беззнаковое число без форматирования");
        System.out.println("пол - символ латиницей f или m.");
        System.out.println(" ");
        System.out.println("Или введите exit для выхода из программы");
    }
    public static void checkDate(String[] date) throws DateException{
        try {
            LocalDate parsedDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
        } catch (RuntimeException e) {
            throw new DateException();
        }
    }
    public static void checkPhoneNumber(String phone) throws PhoneException{
        if (!phone.matches("[0-9]+")) throw new PhoneException();
    }
    public static void checkGender(String gender) throws GenderException{
        if (!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))) throw new GenderException();
    }
    public static void checkStringFormat(String[] input) throws StringFormatException {
        if (input.length > 6) throw new StringFormatException("В сообщении больше элементов, чем требуется");
        else if (input.length < 6) throw new StringFormatException("В сообщении меньше элементов, чем требуется");
    }
}
