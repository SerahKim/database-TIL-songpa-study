package section250528.controller;

import section250528.model.CourseDTO;
import section250528.model.SchoolService;
import section250528.model.StudentDTO;
import section250528.util.PrintResult;

import java.util.List;
import java.util.Map;

public class SchoolController {
    private PrintResult printResult;
    private final SchoolService schoolService;

    public SchoolController() {
        this.printResult = new PrintResult();
        this.schoolService = new SchoolService();
    }

    public void insertStudentTable(Map<String, String> parameter) {
        String name = parameter.get("name");
        int age = Integer.parseInt(parameter.get("age"));
        String major = parameter.get("major");

        StudentDTO student = new StudentDTO();
        student.setStudentName(name);
        student.setStudentAge(age);
        student.setStudentMajor(major);

        if(schoolService.insertStudentTable(student)) {
            printResult.printSuccessMessage("student");
        } else {
            printResult.printErrorMessage("student");
        }
    }

    public void insertCourseTable(Map<String, String> parameter) {
        String title = parameter.get("title");
        String instructor = parameter.get("instructor");
        int credit = Integer.parseInt(parameter.get("credit"));

        CourseDTO course = new CourseDTO();
        course.setCourseTitle(title);
        course.setCourseInstructor(instructor);
        course.setCourseCredit(credit);

        if (schoolService.insertCourseTable(course)) {
            printResult.printSuccessMessage("course");
        } else {
            printResult.printErrorMessage("course");
        }

    }

    public void selectAllStudentTable() {
        List<StudentDTO> studentList = schoolService.selectAllStudentTable();

        if (studentList != null) {
            printResult.printSelectAll(studentList);
        }
    }


    public void selectAllCourseTable() {
        List<CourseDTO> courseList = schoolService.selectAllCourseTable();

        if (courseList != null) {
            printResult.printSelectAll(courseList);
        }
    }
}
