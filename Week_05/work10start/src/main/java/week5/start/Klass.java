package week5.start;

import week5.start.Student;
import lombok.Data;

import java.util.List;

@Data
public class Klass {

    List<Student> students;

    public void dong(){
        System.out.println(this.getStudents());
    }

}