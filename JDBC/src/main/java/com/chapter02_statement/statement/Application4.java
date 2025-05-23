package com.chapter02_statement.statement;

import com.chapter02_statement.model.dto.EmployeeDTO;

import java.sql.*;
import java.util.Scanner;

import static com.chapter02_statement.common.JDBCTemplate.close;
import static com.chapter02_statement.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;

        EmployeeDTO selectedEmp = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("조회할 사번을 입력해주세요. : ");
        String empId = sc.nextLine();

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if(rset.next()) {
                selectedEmp = new EmployeeDTO();

                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                selectedEmp.setEmpName(rset.getString("EMP_NAME"));
                selectedEmp.setEmpNo(rset.getString("EMP_NO"));
                selectedEmp.setEmail(rset.getString("EMAIL"));
                selectedEmp.setPhone(rset.getString("PHONE"));
                selectedEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectedEmp.setJobCode(rset.getString("JOB_CODE"));
                selectedEmp.setSalLevel(rset.getString("SAL_LEVEL"));
                selectedEmp.setSalary(rset.getInt("SALARY"));
                selectedEmp.setBonus(rset.getDouble("BONUS"));
                selectedEmp.setManagerId(rset.getString("MANAGER_ID"));
                selectedEmp.setHireDate(rset.getDate("HIRE_DATE"));
                selectedEmp.setEntDate(rset.getDate("ENT_DATE"));
                selectedEmp.setEntYn(rset.getString("ENT_YN"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
            close(con);
        }
        System.out.println("selectedEmp = " +  selectedEmp);
    }
}
