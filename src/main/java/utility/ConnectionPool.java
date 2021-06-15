package utility;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    final static Logger logger = Logger.getLogger(ConnectionPool.class);
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "12345678";
    private static Connection connection = null;

    public static Connection getConnection() throws Exception{
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            logger.error(e);
        }

        return connection;
    }

    public static void closeConnection(Connection con) throws Exception{
        if(con != null)
            con.close();
    }

}
