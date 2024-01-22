import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataStorageProxy implements IDataStorage {
    private StudentDataStorage realDataStorage;

    public DataStorageProxy() {
        this.realDataStorage = StudentDataStorage.getInstance();
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = realDataStorage.getStudents();

        // Sort students alphabetically by name
        Collections.sort(students, Comparator.comparing(Student::getName));

        // Sort by faculty number:
//         Collections.sort(students, Comparator.comparing(Student::getFacultyNumber));

        return students;
    }

    @Override
    public void saveStudentData(Student student) {
        realDataStorage.saveStudentData(student);
    }
}
