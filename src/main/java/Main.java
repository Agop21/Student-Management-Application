import javax.swing.*;
import java.util.List;

// Main.java
public class Main {
    public static void main(String[] args) {
        // Инициализация на GUI формата за въвеждане на данни
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentInputForm().setVisible(true);
            }
        });

        // Пример за извличане на данни и визуализация
        List<Student> students = StudentDataStorage.getInstance().getStudents();
        students.forEach(student -> System.out.println("Студент: " + student.getName() + ", ФН: " + student.getFacultyNumber()));

    }
}
