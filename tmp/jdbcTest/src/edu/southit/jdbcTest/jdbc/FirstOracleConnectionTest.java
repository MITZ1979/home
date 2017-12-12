package edu.southit.jdbcTest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FirstOracleConnectionTest {

    public static void main(String[] args) throws Exception {
        FirstOracleConnectionTest firstOracleConnectionTest = new FirstOracleConnectionTest();
        firstOracleConnectionTest.testConnection();
    }

    public void testConnection() throws Exception {
        String sql = "select ename, sal from emp where sal > ?";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521/orcl", "vip", "vip"
        );

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 2000);



        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            System.out.printf("%s 的工资是 %d.\n", rs.getString(1), rs.getInt(2));
        }

        rs.close();
        ps.close();
        conn.close();
    }


}
