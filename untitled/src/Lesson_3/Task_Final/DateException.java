package Lesson_3.Task_Final;

public class DateException extends RuntimeException{
    public DateException() {
        super("Неправильный формат даты");
    }
}
