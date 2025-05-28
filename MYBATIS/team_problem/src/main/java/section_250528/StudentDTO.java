package section_250528;

public class StudentDTO {
    private int studentId;
    private String studnetName;
    private int studentAge;
    private String studentMajor;

    public StudentDTO() {}

    public StudentDTO(int studentId, String studnetName, int studentAge, String studentMajor) {
        this.studentId = studentId;
        this.studnetName = studnetName;
        this.studentAge = studentAge;
        this.studentMajor = studentMajor;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudnetName() {
        return studnetName;
    }

    public void setStudnetName(String studnetName) {
        this.studnetName = studnetName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentId=" + studentId +
                ", studnetName='" + studnetName + '\'' +
                ", studentAge=" + studentAge +
                ", studentMajor='" + studentMajor + '\'' +
                '}';
    }
}
