package week5.beanconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import week5.beanconfig.beans.Student;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
@Component
public class AnnotationBean {

    @Bean
    public Student student() {
        return new Student("Anne");
    }
}