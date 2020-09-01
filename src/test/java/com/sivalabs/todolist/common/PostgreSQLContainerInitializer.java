package com.sivalabs.todolist.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class PostgreSQLContainerInitializer
    implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final PostgreSQLContainer<?> sqlContainer;

    static {
        sqlContainer = new PostgreSQLContainer<>("postgres:12-alpine")
            .withDatabaseName("integration-tests-db")
            .withUsername("username")
            .withPassword("password");
        sqlContainer.start();
    }

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
            "spring.datasource.url=" + sqlContainer.getJdbcUrl(),
            "spring.datasource.username=" + sqlContainer.getUsername(),
            "spring.datasource.password=" + sqlContainer.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }

}

