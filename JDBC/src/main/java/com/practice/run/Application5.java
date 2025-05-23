package com.practice.run;

import com.practice.model.dao.EmployeeDAO;
import java.sql.Connection;
import static com.practice.common.JDBCTeamplate.getConnection;

public class Application5 {
    public static void main(String[] args) {
        Connection con = getConnection();
        EmployeeDAO employeeDAO = new EmployeeDAO();

        /* 5. 직원 삭제 */
        int successDelete = employeeDAO.deleteEmp(con);
        if(successDelete > 0) {
            System.out.println("직원을 삭제하는데 성공했습니다.");
        } else {
            System.out.println("직원을 삭제하는데 실패했습니다.");
        }
    }
}
