package week5.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Objects;

/**
 * @Title:
 * @Description:util类
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
public class JdbcUtil {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/geek_time?useUnicode=true&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "root";

    /**
     * 获取DataSource
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 使用Hikari获取DataSource
     */
    public DataSource getHikariDataSource() {
        HikariConfig configuration = new HikariConfig();
        configuration.setJdbcUrl(url);
        configuration.setUsername(username);
        configuration.setPassword(password);
        return new HikariDataSource(configuration);
    }

    /**
     * 建立连接
     */
    private Connection connect() throws SQLException {
//        return getConnection();
        return getHikariDataSource().getConnection();
    }

    /**
     * 关闭资源
     * @param connection
     */
    public void rollback(Connection connection) {
        if (Objects.nonNull(connection)) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeJDBCResourceQuiet(Connection connection, Statement preparedStatement, ResultSet resultSet) {
        if (Objects.nonNull(resultSet)) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (Objects.nonNull(preparedStatement)) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (Objects.nonNull(connection)) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
