package section250528.run;

import section250528.controller.SchoolController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SchoolController schoolController = new SchoolController();

        do {
            System.out.println("1. 학생 테이블에 데이터 삽입");
            System.out.println("2. 강의 테이블에 데에터 삽입");
            System.out.println("3. 등록 테이블에 데이터 삽입");
            System.out.println("4. 학생 테이블 조회");
            System.out.println("5. 강의 테이블 조회");
            System.out.println("6. 등록 테이블 조회");
            System.out.print("메뉴를 선택하세요 : ");
            int num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    schoolController.insertStudentTable(inputStudentDate());
                    break;
                case 2:
                    schoolController.insertCourseTable(inputCourseDate());
                    break;
                case 3:

                case 4 :
                    schoolController.selectAllStudentTable();
                    break;
                case 5:
                    schoolController.selectAllCourseTable();
                    break;
            }
        } while (true);


    }

    private static Map<String, String > inputStudentDate() {
        System.out.println("등록할 학생의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.println("등록할 학생의 나이를 입력해주세요 : ");
        String age = sc.nextLine();
        System.out.println("등록한 학생의 전공을 입력해주세요 : ");
        String major = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("age", age);
        parameter.put("major", major);

        return parameter;
    }

    private static Map<String, String> inputCourseDate() {
        System.out.println("등록할 강의의 이름을 입력하세요 : ");
        String title = sc.nextLine();
        System.out.println("등록할 강사의 이름을 입력해주세요 : ");
        String instructor = sc.nextLine();
        System.out.println("등록한 credit을 입력해주세요 : ");
        String credit = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("title", title);
        parameter.put("instructor", instructor);
        parameter.put("credit", credit);

        return parameter;
    }
}
