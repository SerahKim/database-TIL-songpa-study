package com.xmlmapper;


import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("========= 매퍼 element 테스트 메뉴 ==========");
            System.out.println("1. <resultMap> 서브 메뉴");
            System.out.println("2. <sql> 테스트");
            System.out.println("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    resultMapSubMenu();
                    break;
                case 2 :
                    elementTestService.selectSqlTest();
                    break;
            }
        } while (true);
    }

    private static void resultMapSubMenu() {
        Scanner sc = new Scanner(System.in);

        ElementTestService elementTestService = new ElementTestService();
        do {
            System.out.println("========== <resultMap> 서브 메뉴 =============");
            System.out.println("1. <resultMap> 테스트");
            System.out.println("2. <constructor> 테스트");
            System.out.println("3. <association> 테스트");
            System.out.println("4. <collection> 테스트");
            System.out.println("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    elementTestService.selectResultMapTest();
                    break;
                case 2:
                    elementTestService.selectResultMapConstructorTest();
                    break;
                case 3:
                    elementTestService.selectResultMapAssociationTest();
                    break;
                case 4:
                    elementTestService.selectResultMapCollection();
                    break;

            }
        } while (true);
    }
}
