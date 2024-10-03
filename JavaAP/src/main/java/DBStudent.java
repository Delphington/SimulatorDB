import java.sql.*;

public class DBStudent {

    //  private SrvDB srvDB = new SrvDB(new DBDiscipline());


    public DBStudent() {
    }


    public void setConnectionToBD() {

        try (Connection connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD)) {
            if (connection != null) {
                System.out.println("Соединение установлено!");

                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery("SELECT * FROM user");

                while (results.next()) {
                    // Предположим, у вас есть столбец "name" в вашей таблице
                    String name = results.getString("student_name");
                    System.out.println(name);

                }


                // Пример выполнения запроса
//                String query = "SELECT * FROM students";
//                try (PreparedStatement statement = connection.prepareStatement(query);
//                     ResultSet resultSet = statement.executeQuery()) {
//
//                    while (resultSet.next()) {
//                        // Предположим, у вас есть столбец "name" в вашей таблице
//                        String name = resultSet.getString("student_id");
//                        System.out.println(name);
//
//                    }
//                }


            }
        } catch (SQLException e) {
            System.out.println("Ошибка соединения: " + e.getMessage());
        }

    }


    void GET(int id) {

    }


}
