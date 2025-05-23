package com.chapter03_crud.update;

import com.chapter03_crud.model.dto.MenuDTO;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("변경할 메뉴 번호를 입력하세요 : ");
        int menuCode = sc.nextInt();

        System.out.println("변경할 메뉴의 이름을 입력하세요 : ");
        sc.nextLine();
        String menuName = sc.nextLine();

        System.out.println("변경할 메뉴의 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        MenuDTO changedMenu = new MenuDTO();
        changedMenu.setCode(menuCode);
        changedMenu.setName(menuName);
        changedMenu.setPrice(menuPrice);

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chapter03_crud/mapper/menu-query.xml"));
            String query = prop.getProperty("updateMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, changedMenu.getName());
            pstmt.setInt(2, changedMenu.getPrice());
            pstmt.setInt(3, changedMenu.getCode());

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
            System.out.println("메뉴 수정 성공!");
        } else {
            System.out.println("메뉴 수정 실패!");
        }
    }
}
