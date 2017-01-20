package ch.adriankrebs.services.book.util.JDBC;

import java.sql.*;

/**
 * Created by Adrian on 1/19/2017.
 */
public class JDBCTester {


    public static void main(String[] args) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("select * from STUDENT");

        // get result set metadatea
        int columnCount = rs.getMetaData().getColumnCount();

        System.out.println(columnCount);
    }
}
