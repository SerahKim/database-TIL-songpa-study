package com.chapter02_statement.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.chapter02_statement.common.JDBCTemplate.close;
import static com.chapter02_statement.common.JDBCTemplate.getConnection;

public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        try {
            stmt = con.createStatement();

            String empId = "202";
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

            System.out.println("query = " + query);

            rset = stmt.executeQuery(query);

            System.out.println(rset);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rset);
            close(con);
        }


    }
}
