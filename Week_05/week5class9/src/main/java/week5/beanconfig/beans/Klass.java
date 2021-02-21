package week5.beanconfig.beans;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
@Component
public class Klass {
    List<Student> students;

    public Klass() {}

    public Klass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return students.toString();
    }
}