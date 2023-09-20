package test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class EmpInsertDAO {

    public void empInsert() {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("EMP Table에 입력할 정보를 입력 하세요 ");
        System.out.print("사원번호(4자리) : ");
        int empNO = sc.nextInt();
        System.out.print("이름 : ");
        String name = sc.next();
        System.out.print("직책 : ");
        String job = sc.next();
        System.out.print("상관 사원 번호 : ");
        int mgr = sc.nextInt();
        System.out.print("입사일 : ");
        String date = sc.next();
        System.out.print("급여 : " );
        int sal = sc.nextInt();
        System.out.print("성과급 : " );
        int comm = sc.nextInt();
        System.out.print("부서번호 : ");
        int deptNO = sc.nextInt();

        String query = "INSERT INTO EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES ("
                + empNO + ", " + "'"+ name + "'" + ", " + "'" +
                job + "'" + ", " + mgr + ", " + "'" + date + "'" + ", " + sal + ", " + comm + ", " + deptNO + ")";


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

//9000 장원영 SALESMAN 7698 2023-09-18 2000.0 1000.0 0