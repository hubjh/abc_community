package test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class EmpUpdateDAO {

    void empUpdate() {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("변경할 사원의 이름을 입력 하세요 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("급여 : " );
        int sal = sc.nextInt();
        System.out.print("성과급 : " );
        int comm = sc.nextInt();


        String query = "UPDATE EMP "
                + "SET JOB = " + "'" + job + "', "
                + "SAL = " + sal + ", "
                + "COMM = " + comm + " "
                + "WHERE ENAME = " + "'" + name + "'";

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            int ret = stmt.executeUpdate(query);
            System.out.println("Return : " + ret);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(stmt);
        Common.close(conn);
    }
}