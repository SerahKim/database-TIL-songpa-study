package section250528.model;

import org.apache.ibatis.session.SqlSession;
import section250528.mapper.SchoolMapper;

import java.util.List;

import static section250528.common.Template.getSqlSession;

public class SchoolService {
    private SchoolMapper schoolMapper;

    public boolean insertStudentTable(StudentDTO student) {
        SqlSession sqlSession = getSqlSession();
        schoolMapper = sqlSession.getMapper(SchoolMapper.class);

        int result = schoolMapper.insertStudentTable(student);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean insertCourseTable(CourseDTO course) {
        SqlSession sqlSession = getSqlSession();
        schoolMapper = sqlSession.getMapper(SchoolMapper.class);

        int result = schoolMapper.insertCourseTable(course);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public List<StudentDTO> selectAllStudentTable() {
        SqlSession sqlSession = getSqlSession();
        schoolMapper = sqlSession.getMapper(SchoolMapper.class);

        List<StudentDTO> studentList = schoolMapper.selectAllStudentTable();

        sqlSession.close();

        return studentList;
    }

    public List<CourseDTO> selectAllCourseTable() {
        SqlSession sqlSession = getSqlSession();
        schoolMapper = sqlSession.getMapper(SchoolMapper.class);

        List<CourseDTO> courseList = schoolMapper.selectAllCourseTable();

        sqlSession.close();

        return courseList;
    }
}
