import java.util.Optional;

public interface ActionDiscipline {
    Optional<Object> GET(int numberCourse);
    Optional<Object> GET(String nameTable);
    Optional<Object> DELETE(int id);
    Optional<Object> INSERT(String nameCourse, String dayOfWeek, int numberPair, int numberCourse);
}