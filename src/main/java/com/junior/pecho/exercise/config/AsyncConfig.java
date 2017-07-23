package com.junior.pecho.exercise.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@EnableAsync
@Configuration
@EnableScheduling
@ComponentScan("com.junior.pecho.exercise")
@PropertySource("classpath:config.properties")
public class AsyncConfig extends AsyncConfigurerSupport {
	
	@Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("JuniorPecho-");
        executor.initialize();
        return executor;
    }
	

}
