package com.chapter02_statement.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.chapter02_statement.common.JDBCTemplate.close;
import static com.chapter02_statement.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();

        // stmt 인터페이스를 구현한 인터페이스이기 때문에 stmt에 대한 메소드만 있어도 그 메소드를 사용할 수 있다.
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");
            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " +rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
