package com.sivalabs.todolist.config;

import com.sivalabs.todolist.entity.Todo;
import com.sivalabs.todolist.service.TodoService;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Initializer implements CommandLineRunner {
    private static final String[] SAMPLE_TODOS = {"Learn Kubernetes", "Upgrade Blog"};

    private final ApplicationProperties properties;
    private final TodoService todoService;

    @Override
    public void run(String... args) {
        if (!properties.isInitSampleData()) {
            log.info("Sample data initialization is disabled");
            return;
        }
        Arrays.stream(SAMPLE_TODOS)
                .forEach(
                        t -> {
                            Todo todo = new Todo();
                            todo.setContent(t);
                            todo.setCreatedAt(LocalDateTime.now());
                            todoService.saveTodo(todo);
                        });
    }
}
