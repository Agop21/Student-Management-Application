// Singleton
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataStorage implements IDataStorage{
    private static StudentDataStorage instance;

    private StudentDataStorage() {
        // Private constructor to prevent instantiation.
    }

    public static synchronized StudentDataStorage getInstance() {
        if (instance == null) {
            instance = new StudentDataStorage();
        }
        return instance;
    }


    // Метод за съхранение на данни за студент в базата от данни
    public void saveStudentData(Student student) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "2104agop")) {
            String query = "INSERT INTO students (name, faculty_number, major, course) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getFacultyNumber());
                preparedStatement.setString(3, student.getMajor());
                preparedStatement.setInt(4, student.getCourse());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод за извличане на данни за всички студенти от базата от данни
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "2104agop")) {
            String query = "SELECT * FROM students";
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setName(resultSet.getString("name"));
                    student.setFacultyNumber(resultSet.getString("faculty_number"));
                    student.setMajor(resultSet.getString("major"));
                    student.setCourse(resultSet.getInt("course"));
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}

