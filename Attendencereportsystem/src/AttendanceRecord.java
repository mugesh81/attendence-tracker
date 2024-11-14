import java.util.Date;
import java.util.Objects;

public class AttendanceRecord {
    private int attendanceId;
    private int studentId;
    private int classId;
    private Date date;
    private String status;
    private int markedBy;

    // Constructor
    public AttendanceRecord(int attendanceId, int studentId, int classId, Date date, String status, int markedBy) {
        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.classId = classId;
        this.date = date;
        this.status = status;
        this.markedBy = markedBy;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMarkedBy() {
        return markedBy;
    }

    public void setMarkedBy(int markedBy) {
        this.markedBy = markedBy;
    }

    // toString method for displaying information
    @Override
    public String toString() {
        return "AttendanceRecord{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", classId=" + classId +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", markedBy=" + markedBy +
                '}';
    }

    // Optional: Equals and hashCode methods for comparing objects (for collections or testing)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceRecord that = (AttendanceRecord) o;
        return attendanceId == that.attendanceId &&
                studentId == that.studentId &&
                classId == that.classId &&
                markedBy == that.markedBy &&
                date.equals(that.date) &&
                status.equals(that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceId, studentId, classId, date, status, markedBy);
    }
}
