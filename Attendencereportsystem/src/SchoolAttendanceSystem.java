import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolAttendanceSystem implements AttendanceManagement {

    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    // Method to mark attendance for a student
    @Override
    public void markAttendance(int studentId, int classId, String status, int teacherId) {
        String query = "INSERT INTO AttendanceRecords (student_id, class_id, date, status, marked_by) VALUES (?, ?, CURDATE(), ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, studentId);
            pstmt.setInt(2, classId);
            pstmt.setString(3, status);
            pstmt.setInt(4, teacherId);
            pstmt.executeUpdate();
            System.out.println("Attendance marked successfully.");

        } catch (SQLException e) {
            System.out.println("Error marking attendance: " + e.getMessage());
        }
    }

    // Method to generate an attendance report for a class
    @Override
    public void generateReport(int classId) {
        String query = "SELECT COUNT(*) AS total_students, " +
                "SUM(CASE WHEN status = 'Present' THEN 1 ELSE 0 END) AS total_present, " +
                "SUM(CASE WHEN status = 'Absent' THEN 1 ELSE 0 END) AS total_absent " +
                "FROM AttendanceRecords WHERE class_id = ? GROUP BY class_id";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int totalStudents = rs.getInt("total_students");
                int totalPresent = rs.getInt("total_present");
                int totalAbsent = rs.getInt("total_absent");

                System.out.println("Attendance Report for Class ID " + classId + ":");
                System.out.println("Total Students: " + totalStudents);
                System.out.println("Total Present: " + totalPresent);
                System.out.println("Total Absent: " + totalAbsent);
            } else {
                System.out.println("No attendance records found for the given class.");
            }

        } catch (SQLException e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }

    // Load students from the database
    public void loadStudents() {
        String query = "SELECT * FROM Students";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                Date dob = rs.getDate("dob");

                Student student = new Student(studentId, firstName, lastName, email,dob);
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
    }

    // Load teachers from the database
    public void loadTeachers() {
        String query = "SELECT * FROM Teachers";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int teacherId = rs.getInt("teacher_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String department = rs.getString("department");

                Teacher teacher = new Teacher(teacherId, firstName, lastName, email, department);
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            System.out.println("Error loading teachers: " + e.getMessage());
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        SchoolAttendanceSystem system = new SchoolAttendanceSystem();

        // Load data
        system.loadStudents();
        system.loadTeachers();

        // Example usage: Mark attendance for a student
        system.markAttendance(1, 101, "Present", 1);  // studentId = 1, classId = 101, status = Present, teacherId = 1

        // Example usage: Generate attendance report for a class
        system.generateReport(101);  // classId = 101
    }
}
