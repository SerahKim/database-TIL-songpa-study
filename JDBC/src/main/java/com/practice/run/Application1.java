package com.practice.run;

import com.practice.model.dao.EmployeeDAO;
import com.practice.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.practice.common.JDBCTeamplate.getConnection;

public class Application1 {
    public static void main(String[] args) {
        Connection con = getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* 1. 직원 전체 조회 */
        List<EmployeeDTO> checkAllEmp = employeeDAO.selectAllEmp(con);
        System.out.println(checkAllEmp);
    }
}
