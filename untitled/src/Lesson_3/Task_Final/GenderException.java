package Lesson_3.Task_Final;

public class GenderException extends RuntimeException{
    public GenderException(){
        super("Неправильный формат информации о поле");
    }
}
