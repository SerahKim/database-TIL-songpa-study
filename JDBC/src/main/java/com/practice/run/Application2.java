package com.practice.run;

import com.practice.model.dao.EmployeeDAO;
import com.practice.model.dto.EmployeeDTO;

import java.sql.Connection;

import static com.practice.common.JDBCTeamplate.getConnection;


public class Application2 {
    public static void main(String[] args) {
        Connection con = getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* 2. 직원 상세 조회*/
        EmployeeDTO checkEmpById = employeeDAO.selectByNoEmp(con);
        System.out.println(checkEmpById);
    }
}
