package Lesson_3.Task_Final;

public class PhoneException extends NumberFormatException{
    public PhoneException(){
        super("Неправильный формат номера телефона");
    }
}
