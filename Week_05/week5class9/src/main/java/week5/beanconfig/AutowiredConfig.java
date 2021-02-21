package week5.beanconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import week5.beanconfig.beans.Klass;
import week5.beanconfig.beans.Student;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
@SpringBootApplication
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE, classes = {AnnotationConfig.class}))
public class AutowiredConfig {

    @Autowired
    @Bean
    @Qualifier("school")
    public Klass schoolKlass(List<Student> schoolKlassStudents) {
        return new Klass(schoolKlassStudents);
    }


    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AutowiredConfig.class);
        System.out.println(context.getBean("school"));
    }
}