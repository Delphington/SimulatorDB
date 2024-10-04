import java.util.Optional;


//устилитный класс;
public class SrvDB {
    private static DBStudent dbStudent = new DBStudent();

    private static DBDiscipline dbDiscipline = new DBDiscipline();

    private static String nameDateBase;

    public static void initialization() {
        dbStudent.setConnectionToBD();
        dbDiscipline.setConnectionToBD();
    }

    public static void GET(String nameDateBase, int id) {
        if (nameDateBase.equals("student")) {
            Optional<Object> ans = dbStudent.GET(id);
            if (ans.isPresent()) {
                System.out.println(ans.get());
            } else {
                System.out.println("К сожалению такого объекта нет");
            }
        } else if (nameDateBase.equals("students")) {
            Optional<Object> ans = dbStudent.GET("", id);
            if (ans.isPresent()) {
                System.out.println(ans.get());
            } else {
                System.out.println("К сожалению такого объекта нет");
            }
        } else if (nameDateBase.equals("discipline")) {
            Optional<Object> ans = dbDiscipline.GET(id);
            if (ans.isPresent()) {
                System.out.println(ans.get());
            } else {
                System.out.println(" К сожалению таких элементов нет");
            }
        } else {

        }
    }

    public static void GET(String nameDateBase) {
        Optional<Object> ans = dbDiscipline.GET(nameDateBase);
        if (ans.isPresent()) {
            System.out.println(ans.get());
        } else {
            System.out.println(" К сожалению таких элементов нет");
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
        if(str.equals("student")){
            Optional<Object> ans = dbStudent.DELETE(id);
            if (ans.isPresent()) {
                System.out.println("Было удаленно: " + ans.get());
            } else {
                System.out.println("Ошибка, такого элемента нет.");
            }
        }else if(str.equals("discipline")){
            Optional<Object> ans = dbDiscipline.DELETE(id);
            if (ans.isPresent()) {
                System.out.println("Было удаленно: " + ans.get());
            } else {
                System.out.println("Ошибка, такого элемента нет.");
            }
        }

    }
    public static void PUT(String nameCourse, String dayOfWeek, int numberPair, int numberCourse){
        Optional<Object> ans = dbDiscipline.INSERT(nameCourse,  dayOfWeek, numberPair, numberCourse);
        if (ans.isPresent()) {
            System.out.println("Успешно! Количество добавленных эелементов: " + ans.get());
        } else {
            System.out.println("Элемент не добавлен");
        }
    }
}
