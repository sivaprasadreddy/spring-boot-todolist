package com.sivalabs.todolist.web.controller;

import com.sivalabs.todolist.entity.Todo;
import com.sivalabs.todolist.repo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodos() {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        return todoRepository.findAll(sort);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTodo(@RequestBody Todo todo) {
        todo.setId(null);
        todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }

}
