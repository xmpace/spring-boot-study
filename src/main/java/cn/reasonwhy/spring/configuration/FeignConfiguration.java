package cn.reasonwhy.spring.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    Logger logger() {
        return new Logger.ErrorLogger();
    }
}
