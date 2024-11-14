public interface AttendanceManagement {
    /**
     * Method to mark attendance for a student in a specific class.
     *
     * @param studentId The ID of the student whose attendance is being marked.
     * @param classId   The ID of the class the attendance is being marked for.
     * @param status    The attendance status (e.g., "Present", "Absent").
     * @param teacherId The ID of the teacher marking the attendance.
     */
    void markAttendance(int studentId, int classId, String status, int teacherId);

    /**
     * Method to generate an attendance report for a specific class.
     *
     * @param classId The ID of the class for which the attendance report is to be generated.
     */
    void generateReport(int classId);
}
