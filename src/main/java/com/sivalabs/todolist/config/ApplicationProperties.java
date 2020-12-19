package com.sivalabs.todolist.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("todolist")
public class ApplicationProperties {
    private boolean initSampleData;
}
