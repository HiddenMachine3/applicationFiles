package backend.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("backend.spring")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    Environment environment;
    private final String PASSWORD = "dbtestpass";

    @Bean
    public String doSomething() {
        return (String) environment.getProperty(PASSWORD);
    }

}
