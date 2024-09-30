package com.sivalabs.todolist;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {

    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> sqlContainer() {
        return new PostgreSQLContainer<>("postgres:17-alpine");
    }
}
