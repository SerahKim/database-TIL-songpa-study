package com.chapter01_connection.template;

import java.sql.Connection;

import static com.chapter01_connection.template.JDBCTemplate.close;
import static com.chapter01_connection.template.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        Connection con = getConnection();
        System.out.println("con = " + con);
        close(con);
    }
}
