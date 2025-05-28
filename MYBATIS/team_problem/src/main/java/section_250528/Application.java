package section_250528;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static section_250528.common.Template.getSqlSession;

public class Application {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            System.out.println("=======insert========");
            System.out.println("1. 학생 테이블");
            System.out.println("2. 강의 테이블");
            System.out.println("3. 등록 테이블");
            System.out.println("데이터를 삽입할 테이블 번호를 입력하세요 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    SchoolController.insertStudentTable(inputDate());
                case 2:
                case 3:
            }
        } while (true);


    }

    private static Map<String, String > inputDate() {
        System.out.println("등록할 학생의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.println("등록할 학생의 나이를 입력해주세요 : ");
        String age = sc.nextLine();
        System.out.println("등록한 학생의 전공을 입력해주세요 : ");
        String major = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("studentName", name);
        parameter.put("studentAge", age);
        parameter.put("studentMajor", major);

        return parameter;
    }
}
