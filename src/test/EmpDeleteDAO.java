package test;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDeleteDAO {

    void empDelete() {
        Connection conn = null;
        Statement stmt = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 이름을 입력 하세요 : ");
        String name = sc.next();

        String query = "DELETE FROM EMP WHERE ENAME = " + "'" + name + "'";

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