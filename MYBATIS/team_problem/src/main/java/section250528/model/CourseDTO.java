package section250528.model;

public class CourseDTO {
    private int courseId;
    private String courseTitle;
    private String courseInstructor;
    private int courseCredit;

    public CourseDTO() {}

    public CourseDTO(int courseId, String courseTitle, String courseInstructor, int courseCredit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseInstructor = courseInstructor;
        this.courseCredit = courseCredit;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseInstructor='" + courseInstructor + '\'' +
                ", courseCredit=" + courseCredit +
                '}';
    }
}
