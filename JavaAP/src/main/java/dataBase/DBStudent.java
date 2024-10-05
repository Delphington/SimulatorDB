package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DBStudent implements ActionStudent, Constants {

    private Connection connection; // предоставляет соедниение с БД
    private PreparedStatement preparedStatement; //Позволяет выполнять запросы к БД
    private ResultSet results;  //Результат, который возвращает запрос

    private String ans = new String();


    public DBStudent() {
    }

    /**
     * Устанавливает соединение с базой данных.
     * Этот метод пытается установить соединение с базой данных, используя параметры,
     * указанные в конфигурационном классе {@link Config}. Если соединение успешно,
     * выводится сообщение об успешном подключении. В случае возникновения ошибки
     * при подключении, выводится сообщение об ошибке с деталями исключения.
     * @throws SQLException если не удается установить соединение с базой данных.
     */
    public void setConnectionToBD() {
        try {
            connection = DriverManager.getConnection(Config.URL_STUDY, Config.USER, Config.PASSWORD);
            if (connection != null) {
                System.out.println(MESSAGE_CONNECTION_SUCCESS + " с бд students");
            }

        } catch (SQLException e) {
            System.out.println(MESSAGE_CONNECTION_ERROR + e.getMessage());

        }
    }


    /**
     * Получает информацию о студенте из базы данных по заданному идентификатору студента.
     *
     * <p> Метод выполняет SQL-запрос для поиска студента по его идентификатору
     * и возвращает опциональную строку с деталями студента. Если студент с указанным
     * идентификатором не найден, возвращается пустой объект {@link Optional}.</p>
     *
     * @param id уникальный идентификатор студента, информацию о котором нужно получить
     * @return объект {@link Optional}, содержащий строку с деталями студента, если он найден,
     *         или пустой {@link Optional}, если студент с данным идентификатором не существует
     */
    @Override
    public Optional<Object> GET(int id) {
        // Метод для запроса GET student *id студента*

        StringBuilder temp = new StringBuilder(); //для формирования ответа

        String query = "SELECT * " +
                "FROM students " +
                "WHERE student_id =" + id + ";";
        try {
            preparedStatement = connection.prepareStatement(query); // позволяет выполнить запрос к БД
            results = preparedStatement.executeQuery();

            //если объект не найден, мы сюда не зайдем. Но если без цикла будет .next() -> вылитит Exception
            //Если что-то нашли, то нужно будет итерироваться
            while (results.next()) {
                temp.append(results.getString(STUDENT_ID))
                        .append(SPACE)
                        .append(results.getString(STUDENT_NAME))
                        .append(SPACE)
                        .append(results.getString(STUDENT_COURSE));
            }
            ans = String.valueOf(temp); // перводим все в String

            // Если строка пустаю выкинем оболочку на null
            if (ans.isEmpty()) {
                return Optional.empty();
            }
            return Optional.ofNullable(ans);

        } catch (SQLException e) {
            System.out.println(MESSAGE_ERROR + e.getMessage());
        }
        return Optional.empty();
    }


    // Для выполнения запроса GET students номер курса
    @Override
    public Optional<Object> GET(String nothing, int id) {

        StringBuilder temp = new StringBuilder(); //для формирования ответа

        String query = "SELECT * " +
                "FROM students " +
                "WHERE course_number = " + id + " ORDER BY student_name";

        try {
            preparedStatement = connection.prepareStatement(query); // позволяет выполнить запрос к БД
            results = preparedStatement.executeQuery();

            //если объект не найден, мы сюда не зайдем. Но если .next() -> вылитит Exception
            // Но сли найден, то нужно будет итерироваться
            while (results.next()) {
                temp.append(results.getString(STUDENT_ID))
                        .append(SPACE)
                        .append(results.getString(STUDENT_NAME))
                        .append(SPACE)
                        .append(results.getString(STUDENT_COURSE))
                        .append("\n");
            }
            ans = String.valueOf(temp);

            // Если строка пустаю выкинем оболочку на null
            if (ans.isEmpty()) {
                return Optional.empty();
            }
            return Optional.ofNullable(ans);


        } catch (SQLException e) {
            System.out.println(MESSAGE_ERROR + e.getMessage());
        }

        return Optional.empty();
    }


    @Override
    public Optional<Object> INSERT(String studentName, int course) {
        String query = "INSERT INTO students (student_name, course_number) VALUES ('" +
                studentName + "', '" + course + "');";
        try {
            preparedStatement = connection.prepareStatement(query);

            int x = preparedStatement.executeUpdate(); //Возвращает кол-во элементов и применяем запрос
            if (x == 0) {
                return Optional.empty();  // если недобавили элементы
            }
            return Optional.ofNullable(x);
        } catch (SQLException e) {
            System.out.println(MESSAGE_ERROR + e.getMessage());
        }
        return Optional.empty();

    }

    @Override
    public Optional<Object> DELETE(int id) {
        String query = "DELETE FROM students WHERE student_id = " + id;

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
            System.out.println(MESSAGE_ERROR + e.getMessage());
        }
        return Optional.empty();
    }
}