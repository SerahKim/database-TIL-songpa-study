package com.chapter03_crud.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.chapter03_crud.common.JDBCTemplate.close;
import static com.chapter03_crud.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt =null;
        int result = 0; // INSERT의 경우 int형 변수에 정보가 담김, SELECT는 ResultSet
        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/chapter03_crud/mapper/menu-query.xml"));
            String query = prop.getProperty("insertMenu");
            System.out.println("query = " + query);

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 50000);
            pstmt.setInt(3, 1);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }
        System.out.println("result = " + result);

    }
}
