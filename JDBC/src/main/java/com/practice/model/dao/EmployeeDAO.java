package com.practice.model.dao;

import com.practice.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.practice.common.JDBCTeamplate.close;


public class EmployeeDAO {
    private Properties prop = new Properties();
    private Scanner sc = new Scanner(System.in);

    public EmployeeDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/practice/mapper/employee-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmployeeDTO> selectAllEmp(Connection con){
        Statement stmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> employeeList = null;
        EmployeeDTO employee = null;

        String query = prop.getProperty("selectAllEmp");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            employeeList = new ArrayList<>();

            while (rset.next()) {
                employee = new EmployeeDTO();

                employee.setEmpId(rset.getString("EMP_ID"));
                employee.setEmpName(rset.getString("EMP_NAME"));
                employee.setEmpNo(rset.getString("EMP_NO"));
                employee.setEmail(rset.getString("EMAIL"));
                employee.setPhone(rset.getString("PHONE"));
                employee.setdeptCode(rset.getString("DEPT_CODE"));
                employee.setJobCode(rset.getString("JOB_CODE"));
                employee.setSalary(rset.getInt("SALARY"));

                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(stmt);
        }
        return employeeList;
    }

    public EmployeeDTO selectByNoEmp(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        EmployeeDTO employee = null;

        String query = prop.getProperty("selectByIDEmp");

        try {
            pstmt = con.prepareStatement(query);

            System.out.print("조회할 사원번호를 입력해주세요 : ");
            String empId = sc.nextLine();

            pstmt.setString(1, empId);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                employee = new EmployeeDTO();

                employee.setEmpId(rset.getString("EMP_ID"));
                employee.setEmpName(rset.getString("EMP_NAME"));
                employee.setEmpNo(rset.getString("EMP_NO"));
                employee.setEmail(rset.getString("EMAIL"));
                employee.setPhone(rset.getString("PHONE"));
                employee.setdeptCode(rset.getString("DEPT_CODE"));
                employee.setJobCode(rset.getString("JOB_CODE"));
                employee.setSalary(rset.getInt("SALARY"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }
        return employee;
    }

    public int insertEmp(Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("insertEmp");

        try {
            pstmt = con.prepareStatement(query);

            System.out.print("등록할 사원 번호를 입력하세요 : ");
            String empId = sc.nextLine();

            System.out.print("등록할 직원 이름을 입력하세요 : ");
            String empName = sc.nextLine();

            System.out.print("등록할 직원의 주민등록번호를 입력하세요 : ");
            String empNo = sc.nextLine();

            System.out.print("등록할 직원의 직급 코드를 입력하세요(예시 : J1) : ");
            String jobCode = sc.nextLine();

            System.out.print("등록한 직원의 급여 레벨을 입력하세요(예시 : S1) : ");
            String salLevel = sc.nextLine();

            pstmt.setString(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, empNo);
            pstmt.setString(4, jobCode);
            pstmt.setString(5, salLevel);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int modifyEmp(Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("modifyEmp");

        try {
            pstmt = con.prepareStatement(query);

            System.out.println("변경할 사원 번호를 입력해주세요 : ");
            String empId = sc.nextLine();

            System.out.println("변경할 사원 이름을 입력해주세요 : ");
            String empName = sc.nextLine();

            System.out.print("변경할 직원의 주민등록번호를 입력하세요 : ");
            String empNo = sc.nextLine();

            System.out.print("변경할 직원의 직급 코드를 입력하세요(예시 : J1) : ");
            String jobCode = sc.nextLine();

            System.out.print("변경할 직원의 급여 레벨을 입력하세요(예시 : S1) : ");
            String salLevel = sc.nextLine();

            pstmt.setString(1, empName);
            pstmt.setString(2, empNo);
            pstmt.setString(3, jobCode);
            pstmt.setString(4, salLevel);
            pstmt.setString(5, empId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteEmp (Connection con) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("deleteEmp");

        try {
            pstmt = con.prepareStatement(query);

            System.out.println("삭제할 사원 번호를 입력해주세요 : ");
            String empId = sc.nextLine();

            pstmt.setString(1, empId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
