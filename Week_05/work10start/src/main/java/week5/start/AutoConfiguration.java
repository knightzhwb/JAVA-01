package week5.start;

import week5.start.ISchool;
import week5.start.School;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/applicationContext.xml")
public class AutoConfiguration implements ApplicationContextAware {

    ApplicationContext applicationContext;

    @Bean
    public ISchool school() {
        return applicationContext.getAutowireCapableBeanFactory().createBean(School.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
