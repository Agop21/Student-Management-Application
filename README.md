# Student-Management-Application
The Student Management Application is a Java-based GUI application that allows users to input, save, and visualize data for students. The application supports the storage of student information in a MySQL database, providing functionalities for saving and retrieving data. Additionally, the application includes features for sorting and displaying the student data in a user-friendly manner.

# Requirements
Java: Ensure that Java is installed on your system.
MySQL Database: The application relies on a MySQL database named "students" for data storage.
JDBC Driver: Include the MySQL JDBC driver in the classpath.

# Features
Data Input: Users can enter information for each student, including name, faculty number, major, and course, through the graphical user interface.
Data Storage: The application utilizes a MySQL database to persistently store student data.
Sorting and Display: Users can view a sorted list of students based on their names through the "Show Students" functionality.
Design Patterns: The application incorporates design patterns such as Singleton, Proxy, and Decorator for efficient data storage, access, and visualization.

# Getting Started
Database Setup: Create a MySQL database named "students."
Modify the database connection details in the StudentDataStorage class.
Run the Application: Compile and run the Main class to launch the GUI application.
Enter and Save Data: Use the input fields to enter student data and click the "Save" button to store the information in the database.
Show Students: Click the "Show Students" button to retrieve and display a sorted list of students.

# Contributions and Issues
Contributions and issue reports are welcome! Feel free to submit pull requests or raise issues for any improvements or problems you encounter.
