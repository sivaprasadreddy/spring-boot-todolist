package com.sivalabs.todolist.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(initializers = { PostgreSQLContainerInitializer.class })
@ActiveProfiles("it")
public abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
}
