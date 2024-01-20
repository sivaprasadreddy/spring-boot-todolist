package com.sivalabs.todolist;

import org.springframework.boot.SpringApplication;

public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.from(TodoListApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
