import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SchoolAttendanceSystem attendanceSystem = new SchoolAttendanceSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Mark Attendance");
            System.out.println("2. Generate Report");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Class ID: ");
                    int classId = scanner.nextInt();
                    System.out.print("Enter Status (Present/Absent): ");
                    String status = scanner.next();
                    System.out.print("Enter Teacher ID: ");
                    int teacherId = scanner.nextInt();
                    attendanceSystem.markAttendance(studentId, classId, status, teacherId);
                    break;
                case 2:
                    System.out.print("Enter Class ID for Report: ");
                    int reportClassId = scanner.nextInt();
                    attendanceSystem.generateReport(reportClassId);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
