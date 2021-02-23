package week5.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
//public class Student {
//
//    private int id;
//    private String name;
//
//    public Student(String name) {
//        this.name = name;
//    }
//
//    public Student(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "Student[id=%d, name='%s']", id, name);
//    }
//}
public class Student {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void getStudent(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println("Student{" +
                    "id=" + resultSet.getString(1) +
                    ", name='" + resultSet.getString(2) + '\'' +
                    '}');
        }
    }
}