package com.chapter03_crud.insert;

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

public class Application3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력해주세요. : ");
        String menuName = sc.nextLine();

        System.out.println("메뉴 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        System.out.println("카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();

        System.out.println("판매여부를 결정해주세요 (Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine().toUpperCase();

        MenuDTO newMenu = new MenuDTO();
        newMenu.setName(menuName);
        newMenu.setPrice(menuPrice);
        newMenu.setcategoryCode(categoryCode);
        newMenu.setOrderable(orderableStatus);

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chapter03_crud/mapper/menu-query.xml"));

            String query = prop.getProperty("insertMenu");

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, newMenu.getName());
            pstmt.setInt(2, newMenu.getPrice());
            pstmt.setInt(3, newMenu.getcategoryCode());
            pstmt.setString(4, newMenu.getOrderable());

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
            System.out.println("메뉴 등록 성공");
        } else {
            System.out.println("메뉴 등록 실패");
        }
    }
}
