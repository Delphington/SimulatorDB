
//Класс для ввода и определение какой метод нужно вызвать: GET, PUT, DELETE
public class SrvInput {
    private final static String WARNING = "Не корректный ввод запроса";

    private SrvInput() {
    }  // чтобы нельзя было создать объект

    public static void initialization() {
        SrvDB.initialization(); // Подключаемся к БД
    }

    private static void GET(String line) {
        line = line.trim();  // удаляем  пробелы по краям
        String[] arr = line.split(" ");
        try {  //try-catch нужен для приведение строки в число
            //Определяем какой именно метод вызвать
            if (line.contains("student") && !line.contains("students")) {
                //выдача студента по ID
                if (arr.length == 3) {
                    SrvDB.GET("student", Integer.parseInt(arr[2]));
                    return;
                }
                System.out.println(WARNING);

            } else if (line.contains("students")) {
                //Выдача всех студентов по номеру курса
                if (arr.length == 3) {
                    SrvDB.GET("students", Integer.parseInt(arr[2]));
                    return;
                }
                System.out.println(WARNING);
                //выдача всех занятий в хронологическом порядке по номеру курса
            } else if (line.contains("discipline") && !line.contains("disciplines")) {
                if (arr.length == 3) {
                    SrvDB.GET("discipline", Integer.parseInt(arr[2]));
                    return;
                }
                System.out.println(WARNING);

            } else if (line.contains("disciplines")) {
                SrvDB.GET("disciplines");
            }

        } catch (RuntimeException e) {
            System.out.println(WARNING + "Не верное приведение: " + e.getMessage());
        }
    }


    private static void PUT(String line) {
        line = line.trim();
        String[] arr = line.split(" ");
        try {
            if (line.contains("student")) {
                if (arr.length == 4) {
                    SrvDB.PUT(arr[2], Integer.parseInt(arr[3]));
                    return;
                }
                System.out.println(WARNING);
            } else if (line.contains("discipline")) {
                if (arr.length == 6) {
                    SrvDB.PUT(arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                    return;
                }
                System.out.println(WARNING);
            }

        } catch (RuntimeException e) {
            System.out.println("Не верный тип  данных: " + e.getMessage());
        }

    }

    private static void DELETE(String line) {
        line = line.trim();
        String[] arr = line.split(" ");
        try {
            if (line.contains("student")) {
                if (arr.length == 3) {
                    SrvDB.DELETE("student", Integer.parseInt(arr[2]));
                    return;
                }
                System.out.println(WARNING);
            } else if (line.contains("discipline")) {
                if (arr.length == 3) {
                    SrvDB.DELETE("discipline", Integer.parseInt(arr[2]));
                    return;
                }
                System.out.println(WARNING);
            }
        } catch (RuntimeException e) {
            System.out.println("Не верный тип  данных: " + e.getMessage());
        }
    }

    //Индифицируем какой из методов нужно вызвать
    public static void input(String line) {
        if (line.contains("GET")) {
            GET(line);
        } else if (line.contains("PUT")) {
            PUT(line);
        } else if (line.contains("DELETE")) {
            DELETE(line);
        }
    }
}