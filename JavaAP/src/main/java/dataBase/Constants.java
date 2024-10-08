package dataBase;

/**
 *  Интерфейс для хранения констант
 * */

public interface Constants {
    //общий блок констант
    String SPACE = " ";
    String MESSAGE_ERROR = "Ошибка: ";
    String MESSAGE_CONNECTION_ERROR = "Ошибка соединение: ";
    String MESSAGE_CONNECTION_SUCCESS = "Соединение успешно ";

    //Константы для БД students
    String STUDENT_ID = "student_id";
    String STUDENT_NAME = "student_name";
    String STUDENT_COURSE = "course_number";

    //Константы для БД disciplines
    String DISCIPLINES_ID = "id";
    String DISCIPLINES_NAME = "discipline_name";
    String DISCIPLINES_DAY_OF_WEEK = "day_of_week";
    String DISCIPLINES_PAIR_NUMBER = "pair_number";
    String DISCIPLINES_COURSE_NUMBER = "course_number";
}