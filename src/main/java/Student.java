import java.util.Scanner;

// Student data
public class Student implements Comparable<Student>{
    private String name;
    private String facultyNumber;
    private String major;
    private int course;


    // Constructor, getters and setters
    public Student(String name, String facultyNumber, String major, int course) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.major = major;
        this.course = course;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    // Метод за въвеждане на данни за студент
    public void inputStudentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Име: ");
        this.name = scanner.nextLine();
        System.out.print("Факултетен номер: ");
        this.facultyNumber = scanner.nextLine();
        System.out.print("Специалност: ");
        this.major = scanner.nextLine();
        System.out.print("Курс: ");
        this.course = scanner.nextInt();
    }

    @Override
    public int compareTo(Student student) {
        return 0;
    }
}
