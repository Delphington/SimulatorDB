import java.util.Optional;

public interface ActionStudent {
    Optional<Object> GET(int id);

    Optional<Object> GET(String str, int id);

    Optional<Object> INSERT(String studentName, int course);
}
