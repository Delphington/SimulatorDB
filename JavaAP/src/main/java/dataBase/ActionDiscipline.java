package dataBase;

import java.util.Optional;
/**
 *   Описание поведение класса BDDiscipline
 *   Для удобства каждый метод что-то возвраащет
 * */

public interface ActionDiscipline {
    Optional<Object> GET(int numberCourse);  //выдача всех занятий в хронологическом порядке по номеру курса

    Optional<Object> GET(String nameTable); //вывести полное расписание со всеми полями таблицы disciplines

    Optional<Object> DELETE(int id);

    Optional<Object> INSERT(String nameCourse, String dayOfWeek, int numberPair, int numberCourse);
}