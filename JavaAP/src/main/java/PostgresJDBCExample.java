//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class PostgresJDBCExample {
//    // ... (предыдущий код)
//
//    public static void main(String[] args) {
//        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
//            // Пример выполнения запроса
//            String query = "SELECT * FROM your_table";
//            try (PreparedStatement statement = connection.prepareStatement(query);
//                 ResultSet resultSet = statement.executeQuery()) {
//
//                while (resultSet.next()) {
//                    // Предположим, у вас есть столбец "name" в вашей таблице
//                    String name = resultSet.getString("name");
//                    System.out.println(name);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//    }
//}
