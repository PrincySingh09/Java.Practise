import java.io.*;
import java.util.Scanner;
import java.util.NoSuchElementException;

// Class for representing a student's academic record
class Student {
    // Attributes to hold student details
    private String fullName;
    private int idNumber;
    private double examScore;

    // Constructor to initialize student properties
    public Student(String fullName, int idNumber, double examScore) {
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.examScore = examScore;
    }

    // Accessor for student's full name
    public String getFullName() {
        return fullName;
    }

    // Mutator for student's full name
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Accessor for student's ID number
    public int getIdNumber() {
        return idNumber;
    }

    // Mutator for student's ID number
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    // Accessor for student's exam score
    public double getExamScore() {
        return examScore;
    }

    // Mutator for student's exam score
    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    // Method to compute and return the student's grade
    public char computeGrade() {
        if (examScore >= 95) {
            return 'A';
        } else if (examScore >= 85) {
            return 'B';
        } else if (examScore >= 75) {
            return 'C';
        } else if (examScore >= 55) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

// Subclass for graduate-level students
class GraduateStudent extends Student {
    // Constructor calling the base class constructor
    public GraduateStudent(String fullName, int idNumber, double examScore) {
        super(fullName, idNumber, examScore);
    }

    // Method overridden to potentially implement a different grading system
    @Override
    public char computeGrade() {
        // For now, it uses the grading system defined in the Student class
        return super.computeGrade();
    }
}

// Main class for handling student data operations
public class StudentRecordHandler {
    public static void main(String[] args) {
        // Creating student objects
        Student undergrad = new Student("Princy Singh", 123, 98.0);
        GraduateStudent postgrad = new GraduateStudent("Piyush Singh", 456, 87.0);

        // Outputting student details
        System.out.println("Undergraduate Student: " + undergrad.getFullName() +
                ", ID: " + undergrad.getIdNumber() +
                ", Exam Score: " + undergrad.getExamScore() +
                ", Grade: " + undergrad.computeGrade());

        System.out.println("Graduate Student: " + postgrad.getFullName() +
                ", ID: " + postgrad.getIdNumber() +
                ", Exam Score: " + postgrad.getExamScore() +
                ", Grade: " + postgrad.computeGrade());

        // File operations for saving and loading student data
        saveStudentInfo(undergrad, "undergrad_data.txt");
        try {
            Student retrievedStudent = loadStudentInfo("undergrad_data.txt");
            if (retrievedStudent != null) {
                System.out.println("Loaded Student: " + retrievedStudent.getFullName() +
                        ", ID: " + retrievedStudent.getIdNumber() +
                        ", Exam Score: " + retrievedStudent.getExamScore());
            }
        } catch (IOException e) {
            System.out.println("Error loading student data: " + e.getMessage());
        }
        // Exception handling for invalid student creation and file operations
        try {
            Student invalidStudent = new Student("", -1, -1); // Invalid data
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Student Data: " + e.getMessage());
        }

        try {
            Student missingStudent = loadStudentInfo("missing_file.txt"); // Non-existent file
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // Method to save student information to a file
    private static void saveStudentInfo(Student student, String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            out.println(student.getFullName());
            out.println(student.getIdNumber());
            out.println(student.getExamScore());
        } catch (IOException e) {
            System.out.println("Error saving student data: " + e.getMessage());
        }
    }

    // Method to load student information from a file
    private static Student loadStudentInfo(String filePath) throws IOException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            String fullName = scanner.nextLine();
            int idNumber = Integer.parseInt(scanner.nextLine());
            double examScore = Double.parseDouble(scanner.nextLine());
            return new Student(fullName, idNumber, examScore);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
            throw e;
        } catch (NumberFormatException | NoSuchElementException e) {
            System.out.println("Error reading student data: " + e.getMessage());
            throw e;
        }
    }
}