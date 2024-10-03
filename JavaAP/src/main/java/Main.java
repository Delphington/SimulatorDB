import java.sql.*;
import java.util.Optional;

public class Main {



    public static void main(String[] args) {

        DBStudent dbStudent = new DBStudent();

        dbStudent.setConnectionToBD();
        Optional<Object> ans = dbStudent.GET(1000);
        if(ans.isPresent()){
            System.out.println(ans.get());
        }else{
            System.out.println("К сожалению такого объекта нет");
        }

    }
}
