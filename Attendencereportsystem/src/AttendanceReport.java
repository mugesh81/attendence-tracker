import java.util.Date;
import java.util.Objects;

public class AttendanceReport {
    private int reportId;
    private int classId;
    private Date dateRangeStart;
    private Date dateRangeEnd;
    private int totalStudents;
    private int totalPresent;
    private int totalAbsent;

    // Constructor
    public AttendanceReport(int reportId, int classId, Date dateRangeStart, Date dateRangeEnd, int totalStudents, int totalPresent, int totalAbsent) {
        this.reportId = reportId;
        this.classId = classId;
        this.dateRangeStart = dateRangeStart;
        this.dateRangeEnd = dateRangeEnd;
        this.totalStudents = totalStudents;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
    }

    // Getters and Setters
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getDateRangeStart() {
        return dateRangeStart;
    }

    public void setDateRangeStart(Date dateRangeStart) {
        this.dateRangeStart = dateRangeStart;
    }

    public Date getDateRangeEnd() {
        return dateRangeEnd;
    }

    public void setDateRangeEnd(Date dateRangeEnd) {
        this.dateRangeEnd = dateRangeEnd;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalPresent() {
        return totalPresent;
    }

    public void setTotalPresent(int totalPresent) {
        this.totalPresent = totalPresent;
    }

    public int getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(int totalAbsent) {
        this.totalAbsent = totalAbsent;
    }

    // toString method for displaying the information in a readable format
    @Override
    public String toString() {
        return "AttendanceReport{" +
                "reportId=" + reportId +
                ", classId=" + classId +
                ", dateRangeStart=" + dateRangeStart +
                ", dateRangeEnd=" + dateRangeEnd +
                ", totalStudents=" + totalStudents +
                ", totalPresent=" + totalPresent +
                ", totalAbsent=" + totalAbsent +
                '}';
    }

    // Optional: Equals and hashCode methods for comparing AttendanceReport objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceReport that = (AttendanceReport) o;
        return reportId == that.reportId &&
                classId == that.classId &&
                totalStudents == that.totalStudents &&
                totalPresent == that.totalPresent &&
                totalAbsent == that.totalAbsent &&
                dateRangeStart.equals(that.dateRangeStart) &&
                dateRangeEnd.equals(that.dateRangeEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, classId, dateRangeStart, dateRangeEnd, totalStudents, totalPresent, totalAbsent);
    }
}
