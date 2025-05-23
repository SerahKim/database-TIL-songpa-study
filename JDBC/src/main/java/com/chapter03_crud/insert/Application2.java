package com.chapter03_crud.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.chapter03_crud.common.JDBCTemplate.close;
import static com.chapter03_crud.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chapter03_crud/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");

            Scanner sc = new Scanner(System.in);

            System.out.print("메뉴의 이름을 입력하세요 : ");
            String menuName = sc.nextLine();

            System.out.print("메뉴의 가격을 입력하세요 : ");
            int menuPrice = sc.nextInt();

            System.out.print("카레고리 코드를 입력하세요 : ");
            int categoryCode = sc.nextInt();

            System.out.print("판매 여부를 결정해주세요(Y/N) : ");
            sc.nextLine();
            String orderableStatus = sc.nextLine().toUpperCase();

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);
            pstmt.setInt(2, menuPrice);
            pstmt.setInt(3, categoryCode);
            pstmt.setString(4, orderableStatus);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        if (result > 0 ) {
            System.out.println("메뉴 등록을 성공했습니다.");
        } else {
            System.out.println("메뉴 등록을 실패했습니다.");
        }

    }

}
