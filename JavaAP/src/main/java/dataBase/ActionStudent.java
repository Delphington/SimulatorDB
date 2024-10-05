package dataBase;

import java.util.Optional;

/**
 *   Описание поведение класса BDStudent
 *   Для удобства каждый метод что-то возвраащет
 * */
public interface ActionStudent {
    Optional<Object> GET(int id); //  выдача студента по id

    Optional<Object> GET(String str, int id); //выдача всех студентов в алфавитном порядке по номеру курса

    Optional<Object> INSERT(String studentName, int course);

    Optional<Object> DELETE(int id);
}