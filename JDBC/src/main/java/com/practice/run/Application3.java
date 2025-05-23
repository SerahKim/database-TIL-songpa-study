package com.practice.run;

import com.practice.model.dao.EmployeeDAO;
import java.sql.Connection;
import static com.practice.common.JDBCTeamplate.getConnection;

public class Application3 {
    public static void main(String[] args) {
        Connection con = getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* 3. 직원 등록 */
        int successInsert = employeeDAO.insertEmp(con);
        if(successInsert > 0) {
            System.out.println("직원 등록을 성공했습니다.");
        } else {
            System.out.println("직원 등록을 실패했습니다.");
        }
    }
}
