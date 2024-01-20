package com.sivalabs.todolist.config;

import com.sivalabs.todolist.domain.Todo;
import com.sivalabs.todolist.domain.TodoService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private static final List<String> SAMPLE_TODOS = List.of(
            "Learn SpringBoot",
            "Learn VueJS",
            "Write blog post on GitHub Actions",
            "Learn Kubernetes",
            "Upgrade Blog",
            "Publish YouTube video on Quarkus");

    private final ApplicationProperties properties;
    private final TodoService todoService;

    @Override
    public void run(String... args) {
        if (!properties.isInitSampleData()) {
            log.info("Sample data initialization is disabled");
            return;
        }
        SAMPLE_TODOS.forEach(t -> {
            Todo todo = new Todo();
            todo.setContent(t);
            todo.setCreatedAt(LocalDateTime.now());
            todoService.saveTodo(todo);
        });
    }
}
