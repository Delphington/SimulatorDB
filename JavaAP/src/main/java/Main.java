import java.sql.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        SrvDB.initialization();
       // SrvDB.GET("student", 100);
       // SrvDB.GET("students", 20);
        SrvDB.PUT("Capy", 10); //валидация данных на курс
    }
}
