import java.sql.*;
import java.util.Optional;

public class DBDiscipline implements ActionDiscipline, ConstantsStudents {

    Connection connection; // предоставляет соедниение с БД
    PreparedStatement preparedStatement; //Позволяет выполнять запросы к БД
    ResultSet results;
    StringBuilder temp = new StringBuilder();
    String ans = new String();


    public DBDiscipline() {}

    public void setConnectionToBD() {

        try {
            connection = DriverManager.getConnection(Config.URL_STUDY, Config.USER, Config.PASSWORD);
            if (connection != null) {
                System.out.println("Соединение установлено!");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка соединения Дисциплины: " + e.getMessage());
        }
    }


    @Override
    public Optional<Object> GET(int number_course) {
        String query = "SELECT * " +
                "FROM disciplines " +
                "WHERE course_number  = " + number_course + ";";
        try {
            preparedStatement = connection.prepareStatement(query); // позволяет выполнить запрос к БД
            results = preparedStatement.executeQuery();

            //если объект не найден, мы сюда не зайдем. Но если .next() -> вылитит Exception
            // Но сли найден, то нужно будет итерироваться
            while (results.next()) {
//                temp.append(results.getString(DISCIPLINES_ID))
//                        .append(Config.SPACE)
//                        .append(results.getString(DISCIPLINES_NAME))
//                        .append(Config.SPACE)
//                        .append(results.getString(DISCIPLINES_DAY_OF_WEEK))
//                        .append(Config.SPACE)
//                        .append(results.getString(DISCIPLINES_PAIR_NUMBER))
//                        .append(Config.SPACE)
//                        .append(results.getString(DISCIPLINES_COURSE_NUMBER))
//                        .append('\n');


                temp.append(results.getString(DISCIPLINES_NAME)).append('\n');
            }
            ans = String.valueOf(temp);
            // Если строка пустаю выкинем оболочку на null
            if (ans.isEmpty()) {
                return Optional.empty();
            }
            return Optional.ofNullable(ans);

        } catch (SQLException e) {
            System.out.println("Какая-то ошибка: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Object> GET(String nameTable) {
        String query = "SELECT * FROM disciplines;";
        try {
            preparedStatement = connection.prepareStatement(query); // позволяет выполнить запрос к БД
            results = preparedStatement.executeQuery();

            //если объект не найден, мы сюда не зайдем. Но если .next() -> вылитит Exception
            // Но сли найден, то нужно будет итерироваться
            while (results.next()) {
                temp.append(results.getString(DISCIPLINES_ID))
                        .append(Config.SPACE)
                        .append(results.getString(DISCIPLINES_NAME))
                        .append(Config.SPACE)
                        .append(results.getString(DISCIPLINES_DAY_OF_WEEK))
                        .append(Config.SPACE)
                        .append(results.getString(DISCIPLINES_PAIR_NUMBER))
                        .append(Config.SPACE)
                        .append(results.getString(DISCIPLINES_COURSE_NUMBER))
                        .append('\n');
            }
            ans = String.valueOf(temp);
            // Если строка пустаю выкинем оболочку на null
            if (ans.isEmpty()) {
                return Optional.empty();
            }
            return Optional.ofNullable(ans);

        } catch (SQLException e) {
            System.out.println("Какая-то ошибка: " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Object> DELETE(int id) {

        String query = "DELETE FROM disciplines WHERE id = " + id;

        try {
            preparedStatement = connection.prepareStatement(query);

            // Выполняем запрос
            int x = preparedStatement.executeUpdate();
            // Если строка пустаю выкинем оболочку на null
            if (x == 0) {
                return Optional.empty();
            }
            return Optional.ofNullable(x);


        } catch (SQLException e) {
            System.out.println("Какая-то ошибка: " + e.getMessage());
        }
        return Optional.empty();
    }


    @Override
    public Optional<Object> INSERT(String nameCourse, String dayOfWeek, int numberPair, int numberCourse) {
        String query = "INSERT INTO disciplines (discipline_name, day_of_week,pair_number,course_number ) " +
                "VALUES ('" + nameCourse + "', '" + dayOfWeek + "',  '" + numberPair + "', '" + numberCourse + "' );";
        try {
            preparedStatement = connection.prepareStatement(query);

            int x = preparedStatement.executeUpdate(); //Возвращает кол-во элементов
            if (x == 0) {
                return Optional.empty();
            }
            return Optional.ofNullable(x);
        } catch (SQLException e) {
            System.out.println("Какая-то ошибка: " + e.getMessage());
        }
        return Optional.empty();

    }
}