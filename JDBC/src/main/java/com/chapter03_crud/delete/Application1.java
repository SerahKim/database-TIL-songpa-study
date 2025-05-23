package com.chapter03_crud.delete;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import static com.chapter03_crud.common.JDBCTemplate.close;
import static com.chapter03_crud.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chapter03_crud/mapper/menu-query.xml"));
            String query = prop.getProperty("deleteMenu");

            Scanner sc = new Scanner(System.in);
            System.out.println("삭제할 메뉴 번호를 입력해주세요 : ");
            int menuCode = sc.nextInt();

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, menuCode);

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
        if (result > 0) {
            System.out.println("메뉴 삭제 성공!");
        } else {
            System.out.println("메뉴 삭제 실패!");
        }
    }
}
