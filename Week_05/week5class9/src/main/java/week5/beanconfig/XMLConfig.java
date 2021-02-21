package week5.beanconfig;

import week5.beanconfig.beans.Klass;
import week5.beanconfig.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
public class XMLConfig {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Student Anne = (Student) context.getBean("Anne");
        System.out.println(Anne);
        Student Bob = (Student) context.getBean("Bob");
        System.out.println(Bob);

        Klass klass = context.getBean("klass", Klass.class);
        System.out.println(klass);
    }
}
