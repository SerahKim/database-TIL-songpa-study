package section250528.mapper;

import section250528.model.CourseDTO;
import section250528.model.StudentDTO;

import java.util.List;

public interface SchoolMapper {
    int insertStudentTable(StudentDTO student);

    int insertCourseTable(CourseDTO course);

    List<StudentDTO> selectAllStudentTable();

    List<CourseDTO> selectAllCourseTable();
}
