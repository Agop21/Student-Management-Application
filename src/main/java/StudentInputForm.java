import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentInputForm extends JFrame {

    JTextField nameField;
    JTextField facultyNumberField;
    JTextField courseField;
    JTextField majorField;
    javax.swing.JPanel saveData;
    public Object students;


    public StudentInputForm() {
        setTitle("Въвеждане на Данни за Студент");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeComponents();

    }

    private void initializeComponents() {
        setNameField(new JTextField(20));
        setFacultyNumberField(new JTextField(20));
        setMajorField(new JTextField(20));
        setCourseField(new JTextField(20));
        saveData = new JPanel();


        setLayout(new GridLayout(5, 3));

        add(new JLabel("Име:"));
        add(getNameField());

        add(new JLabel("Факултетен номер:"));
        add(getFacultyNumberField());

        add(new JLabel("Специалност:"));
        add(getMajorField());

        add(new JLabel("Курс:"));
        add(getCourseField());


        add(new SaveData( this));
        add(new ShowStudents());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextField getFacultyNumberField() {
        return facultyNumberField;
    }

    public void setFacultyNumberField(JTextField facultyNumberField) {
        this.facultyNumberField = facultyNumberField;
    }

    public JTextField getMajorField() {
        return majorField;
    }

    public void setMajorField(JTextField majorField) {
        this.majorField = majorField;
    }

    public JTextField getCourseField() {
        return courseField;
    }

    public void setCourseField(JTextField courseField) {
        this.courseField = courseField;
    }

}
