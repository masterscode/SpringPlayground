package spring.springdemo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanUtils {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
