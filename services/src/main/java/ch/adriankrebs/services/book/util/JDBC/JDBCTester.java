package ch.adriankrebs.services.book.util.JDBC;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Adrian on 1/19/2017.
 */
public class JDBCTester {


    public static void main(String[] args) throws SQLException {


        /*
        Applications no longer need to explicitly load JDBC drivers using Class.forName().
        DriverManager have been enhanced, thus no need to deal with the driver itself anymore
        driver file with its entry or attemt to locate a suitable driver in the classpath
         */
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "ette");
        connectionProps.put("password", "ewrwrwr");
        String dbms = "derby";
        String serverName = "localhost";
        String portNumber = "1527";


        conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://" +
                            serverName +
                            ":" + portNumber + "/",
                    connectionProps);

        System.out.println("Connected to database");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from STUDENT");

        rs.updateString(1,"test");
        rs.updateRow();

        // get result set metadatea
        int columnCount = rs.getMetaData().getColumnCount();

        System.out.println(columnCount);
        conn.commit(); // commit is on the connection ... like we use it on the entity manager which represents our connection




        conn.setAutoCommit(false);
        stmt.executeUpdate("update student set status=1");
        Savepoint savePoint1 = conn.setSavepoint("step1done");
        stmt.executeUpdate("update student set gpa=4.0");
        if("tester".length() > 2){
            conn.rollback(savePoint1);
        }
        conn.commit(); //query 1 will be committed but query 2 will not be committed.


    }
}
