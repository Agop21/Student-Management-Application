import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStudents extends JPanel{
    StudentInputForm frame;
    ShowStudents original = null;

    public ShowStudents() {
        initComponentt();
        original = this;
    }
    @SuppressWarnings("unchecked")
    private void initComponentt() {
        JButton showStudent = new JButton();
        showStudent.setText("Покажи студенти");

        showStudent.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                showStudentsData();
            }
        });
        add(showStudent);
    }

    private void showStudentsData() {
        try {
//            List<Student> students = StudentDataStorage.getInstance().getStudents();

            DataStorageProxy proxy = new DataStorageProxy();
            List<Student> students = proxy.getStudents();
            if (students.isEmpty() ){
                JOptionPane.showMessageDialog(this, "Няма записани студенти в базата данни.", "Информация", JOptionPane.INFORMATION_MESSAGE);
            } else {
//                Collections.sort(students, Comparator.comparing(Student::getName));
                StringBuilder message = new StringBuilder("Студенти в базата данни:\n");
                for (Student student : students) {
                    message.append("Име: ").append(student.getName()).append(", ФН: ").append(student.getFacultyNumber())
                            .append(", Специалност: ").append(student.getMajor()).append(", Курс: ").append(student.getCourse()).append("\n");
                }
                JOptionPane.showMessageDialog(this, message.toString(), "Списък със студенти", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            // Handle exceptions (e.g., database connection issues)
            JOptionPane.showMessageDialog(this, "Възникна грешка при извличане на данни за студентите.", "Грешка", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Log the exception details
        }
    }


    public ShowStudents(StudentInputForm frame) {
        initComponentt();
        setPanelFrame(frame);
        original = this;
    }

    private void setPanelFrame(StudentInputForm frame) {
        this.frame = frame;
    }
    public StudentInputForm getPanelFrame() {
        return this.frame;
    }

    public ShowStudents render() {
        return this.original;
    }
}
