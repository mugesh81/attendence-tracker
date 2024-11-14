import java.util.Objects;

public class Teacher {
    private int teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String department;

    // Constructor
    public Teacher(int teacherId, String firstName, String lastName, String email, String department) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
    }

    // Getters and Setters
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method to display teacher information
    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    // Optional: Equals and hashCode methods for comparing Teacher objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId &&
                firstName.equals(teacher.firstName) &&
                lastName.equals(teacher.lastName) &&
                email.equals(teacher.email) &&
                department.equals(teacher.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, firstName, lastName, email, department);
    }
}
