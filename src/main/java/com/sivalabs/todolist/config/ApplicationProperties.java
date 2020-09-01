package com.sivalabs.todolist.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("myapp")
public class ApplicationProperties {

}
