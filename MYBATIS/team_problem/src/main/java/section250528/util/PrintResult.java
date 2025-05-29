package section250528.util;

import section250528.model.StudentDTO;

import java.util.List;

public class PrintResult {
    public void printSuccessMessage(String flag) {
        String message = "";
        switch (flag) {
            case "student" :
                message = "학생 테이블 데이터 삽입 성공!";
            case "course" :
                message = "강의 테이블 데이터 삽입 성공!";
        }
        System.out.println(message);
    }

    public void printErrorMessage(String flag) {
        String message = "";
        switch (flag) {
            case "student" :
                message = "힉셍 테이블 데이터 삽입 실패";
            case "course" :
                message = "강의 테이블 데이터 삽입 실패";
        }
        System.out.println(message);
    }

    public <T> void printSelectAll(List<T> objectList) {
        for (T object : objectList) {
            System.out.println(object);
        }
    }
}
