package week5.jdbc;

import java.sql.*;
import java.util.Random;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
public class JdbcApplication {
    private static String INSERT_SQL = String.format("insert into student (student.id,student.name)values (%d,'%s');", new Random().nextInt(1000), "anne");
    private static String SELECT_SQL = "select * from student";
    private static String UPDATE_SQL = "update student set student.name = 'bob' where student.name='anne'";
    private static String DELTER_SQL = "DELETE FROM `geek_time`.`student`";

    public static void main(String[] args) throws SQLException {
        JdbcUtil jdbcUtil = new JdbcUtil();
//        Connection connection = jdbcUtil.getConnection();
        Connection connection = jdbcUtil.getHikariDataSource().getConnection();
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
        Integer rs = preparedStatement.executeUpdate();
//        System.out.println("插入Sql" + INSERT_SQL + "共变更内容:" + rs);
//        get(statement);
//        rs = statement.executeUpdate(UPDATE_SQL);
//        System.out.println("修改Sql" + UPDATE_SQL + "共变更内容:" + rs);
//        get(statement);
//        rs = statement.executeUpdate(DELTER_SQL);
//        System.out.println("删除Sql" + DELTER_SQL + "共变更内容:" + rs);
//        get(statement);
        //事务
        connection.setAutoCommit(false);
        try {
            preparedStatement = connection.prepareStatement(INSERT_SQL);
            rs = preparedStatement.executeUpdate();
            System.out.println("插入Sql" + INSERT_SQL + "共变更内容:" + rs);
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
            System.out.println("发生异常导致回滚,插入失败");
        }
        JdbcUtil.closeJDBCResourceQuiet(connection, statement, null);
    }

    public static void get(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery(SELECT_SQL);
        new Student().getStudent(resultSet);
    }
}