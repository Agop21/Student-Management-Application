import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveData extends JPanel {
    StudentInputForm frame;
    SaveData original;

    @SuppressWarnings("unchecked")
    private void initComponent() {
        JButton saveButton = new JButton();
        saveButton.setText("Запази");

    	/*saveButton.addActionListener((ActionEvent e) -> {
    	 	 // String nameField = ((AbstractButton) frame.JTextField).getText();

         });*/
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveStudentData();
            }
        });
        add(saveButton);

        //render().add(saveButton);
    }
    private void saveStudentData() {
        try {
            Student student = new Student();
            student.setName(frame.getNameField().getText());
            student.setFacultyNumber(frame.getFacultyNumberField().getText());
            student.setMajor(frame.getMajorField().getText());
            student.setCourse(Integer.parseInt(frame.getCourseField().getText()));

            StudentDataStorage.getInstance().saveStudentData(student);

            // Provide feedback to the user
            JOptionPane.showMessageDialog(this, "Студентът е успешно записан.", "Успех", JOptionPane.INFORMATION_MESSAGE);

            // Clear the input fields after successful save
            clearInputFields(frame);
        } catch (NumberFormatException ex) {
            // Handle invalid course input
            JOptionPane.showMessageDialog(this, "Моля, въведете валиден курс.", "Грешка", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            // Handle other exceptions (e.g., database connection issues)
            JOptionPane.showMessageDialog(this, "Възникна грешка при записа на студента.", "Грешка", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Log the exception details
        }
    }

    private void clearInputFields(StudentInputForm frame) {
        frame.nameField.setText("");
        frame.facultyNumberField.setText("");
        frame.majorField.setText("");
        frame.courseField.setText("");

    }
    public SaveData(StudentInputForm frame) {
        initComponent();
        setPanelFrame(frame);
        original = this;
    }

    private void setPanelFrame(StudentInputForm frame) {
        this.frame = frame;
    }
    public StudentInputForm getPanelFrame() {
        return this.frame;
    }

    public SaveData render() {
        return this.original;
    }


}

