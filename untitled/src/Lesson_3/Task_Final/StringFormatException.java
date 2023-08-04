package Lesson_3.Task_Final;

public class StringFormatException extends RuntimeException{
    public StringFormatException(String details){
        super("Неправильный формат сообщения - " + details);
    }
}
