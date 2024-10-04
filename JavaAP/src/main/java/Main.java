import java.sql.*;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        SrvDB.initialization();
      //  SrvDB.GET("student", 1000);
       // SrvDB.GET("students", 2);
        //todo: Ошибка
        //SrvDB.PUT("Capy", 10); //валидация данных на курс
        SrvDB.DELETE(1000);
        //-------------------------


    }
}
