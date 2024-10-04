import java.util.Optional;


//устилитный класс;
public class SrvDB {
    private static DBStudent dbStudent = new DBStudent();

    private static String nameDateBase;

    public static void initialization() {
        dbStudent.setConnectionToBD();
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
        }
    }

    //todo: Ошибка
    public static void PUT(String studentName, int course) {
        Optional<Object> ans = dbStudent.INSERT(studentName, course);
        if (ans.isPresent()) {
            System.out.println("Успешно! Количество добавленных эелементов: " + ans.get());
        } else {
            System.out.println("Элемент не добавлен");
        }

    }


    public static void DELETE(int id) {
        Optional<Object> ans = dbStudent.DELETE(id);

        if (ans.isPresent()) {
            System.out.println("Было удаленно: " + ans.get());
        } else {
            System.out.println("Ошибка, такого элемента нет.");
        }
    }
}
