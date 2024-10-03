import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBStudent implements ActionStudent, ConstantsStudents {

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet results;
    StringBuilder ans =new StringBuilder();
   // ans = null;
    String strt = new String();


    public DBStudent() {}

    public void setConnectionToBD() {

        try {
            connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
            if (connection != null) {
                System.out.println("Соединение установлено!");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка соединения: " + e.getMessage());

        }
    }


    @Override
    public Optional<Object> GET(int id) {
        String str = "SELECT * FROM students WHERE student_id =" + String.valueOf(id) + "";
        try {
            preparedStatement = connection.prepareStatement(str);
            results = preparedStatement.executeQuery();

            //Если неверное значени, то он  сюда не зайдет, ибо если просто оставить  будут ошибка
            while (results.next()) {
                System.out.println("Im here");
                ans.append(results.getString(STUDENT_ID))
                        .append(Config.SPACE)
                        .append(results.getString(STUDENT_NAME))
                        .append(Config.SPACE)
                        .append(results.getString(STUDENT_COURSE));
                strt = String.valueOf(ans);
            }

            if(strt.isEmpty()){
                return Optional.ofNullable(null);
            }
            return Optional.of(strt);

        } catch (SQLException e) {
            System.out.println("Какая-то ошибка: " + e.getMessage());
        }
        return Optional.ofNullable(null);
    }
}
