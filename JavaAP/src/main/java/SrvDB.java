import dataBase.DBDiscipline;
import dataBase.DBStudent;

import java.util.Optional;


//устилитный класс для работы с двумя таблицами
public class SrvDB {
    private SrvDB() { } //чтобы нельзя было создать объект

    private static DBStudent dbStudent = new DBStudent(); // для работы с БД students

    private static DBDiscipline dbDiscipline = new DBDiscipline(); //для работы с БД disciplines


    // Метод для подключение к БД
    public static void initialization() {
        dbStudent.setConnectionToBD();
        dbDiscipline.setConnectionToBD();
    }

    // Метод, который аккумулирует работу с Двумя таблицами
    public static void GET(String nameDateBase, int id) {
        if (nameDateBase.equals("student")) {
            Optional<Object> ans = dbStudent.GET(id);
            if (ans.isPresent()) { // проверяем, что Option not null
                System.out.println(ans.get());
            } else {
                System.out.println("id = " + id + " - К сожалению такого объекта нет");
            }
        } else if (nameDateBase.equals("students")) {
            Optional<Object> ans = dbStudent.GET("", id);
            if (ans.isPresent()) {
                System.out.println(ans.get());
            } else {
                System.out.println("CourseNumber = " + id + " - К сожалению такого объекта нет");
            }
        } else if (nameDateBase.equals("discipline")) {
            Optional<Object> ans = dbDiscipline.GET(id);
            if (ans.isPresent()) {
                System.out.println(ans.get());
            } else {
                System.out.println("CourseNumber = " + id + " - К сожалению таких элементов нет");
            }
        }
    }

    // спецально отдельно для такого "не похожего запроса"
    //GET disciplines – вывести полное расписание со всеми полями таблицы disciplines
    public static void GET(String nameDateBase) {
        Optional<Object> ans = dbDiscipline.GET(nameDateBase);
        if (ans.isPresent()) {
            System.out.println(ans.get());
        } else {
            System.out.println("К сожалению таких элементов нет");
        }
    }

    public static void PUT(String studentName, int course) {
        Optional<Object> ans = dbStudent.INSERT(studentName, course);
        if (ans.isPresent()) {
            System.out.println("Успешно! Количество добавленных эелементов: " + ans.get());
        } else {
            System.out.println("Элемент не добавлен");
        }
    }


    public static void DELETE(String str, int id) {
        if (str.equals("student")) {
            Optional<Object> ans = dbStudent.DELETE(id);
            if (ans.isPresent()) {
                System.out.println("Было удаленно: " + ans.get());
            } else {
                System.out.println("Ошибка, такого элемента нет.");
            }
        } else if (str.equals("discipline")) {
            Optional<Object> ans = dbDiscipline.DELETE(id);
            if (ans.isPresent()) {
                System.out.println("Было удаленно: " + ans.get());
            } else {
                System.out.println("Ошибка, такого элемента нет.");
            }
        }

    }

    public static void PUT(String nameCourse, String dayOfWeek, int numberPair, int numberCourse) {
        Optional<Object> ans = dbDiscipline.INSERT(nameCourse, dayOfWeek, numberPair, numberCourse);
        if (ans.isPresent()) {
            System.out.println("Успешно! Количество добавленных эелементов: " + ans.get());
        } else {
            System.out.println("Элемент не добавлен");
        }
    }
}
