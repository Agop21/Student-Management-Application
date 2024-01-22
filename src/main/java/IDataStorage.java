// IDataStorage.java
import java.util.List;

public interface IDataStorage {
    List<Student> getStudents();
    void saveStudentData(Student student);

}
