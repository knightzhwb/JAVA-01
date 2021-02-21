package week5.beanconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import week5.beanconfig.beans.Student;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
public class AnnotationConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("week5.beanconfig");
        Student Anne = (Student) context.getBean("student");
        System.out.println(Anne);
    }
}
