package week5.beanconfig.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author:Zhang wenbin
 * @Date:2021/2/20
 */
@Component
public class School {

    @Qualifier("school")
    @Autowired(required = true)
    Klass class1;

    @Override
    public String toString() {
        return "{Klass: " + class1.toString() + "}";
    }
}
