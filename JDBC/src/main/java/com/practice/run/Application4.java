package com.practice.run;

import com.practice.model.dao.EmployeeDAO;

import java.sql.Connection;

import static com.practice.common.JDBCTeamplate.getConnection;

public class Application4 {
    public static void main(String[] args) {
        Connection con = getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* 4. 직원 변경 */
        int successUpdate = employeeDAO.modifyEmp(con);
        if(successUpdate > 0) {
            System.out.println("직원정보 변경을 성공했습니다.");
        } else {
            System.out.println("직원정보 변경을 실패했습니다.");
        }
    }
}
