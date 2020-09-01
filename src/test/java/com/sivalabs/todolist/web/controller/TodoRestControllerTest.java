package com.sivalabs.todolist.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sivalabs.todolist.entity.Todo;
import com.sivalabs.todolist.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoRestController.class)
class TodoRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Todo> todoList;

    @BeforeEach
    void setUp() {

        this.todoList = new ArrayList<>();
        this.todoList.add(new Todo(1L, "First Todo", LocalDateTime.now(), null));
        this.todoList.add(new Todo(2L, "Second Todo", LocalDateTime.now(), null));
        this.todoList.add(new Todo(3L, "Third Todo", LocalDateTime.now(), null));
    }

    @Test
    void shouldFetchAllTodos() throws Exception {
        given(todoService.getTodos()).willReturn(this.todoList);

        this.mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(todoList.size())));
    }

    @Test
    void shouldCreateNewTodo() throws Exception {
        given(todoService.saveTodo(any(Todo.class))).willAnswer((invocation) -> invocation.getArgument(0));

        Todo todo = new Todo(null, "New Todo", LocalDateTime.now(), null);
        this.mockMvc.perform(post("/api/todos")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todo)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.content", is(todo.getContent())))
                .andExpect(jsonPath("$.created_at", notNullValue()));
    }

    @Test
    void shouldDeleteTodo() throws Exception {
        Long todoId = 1L;
        Todo todo = new Todo(todoId, "Todo", LocalDateTime.now(), null);
        given(todoService.deleteTodo(todo.getId())).willReturn(true);

        this.mockMvc.perform(delete("/api/todos/{id}", todo.getId()))
                .andExpect(status().isNoContent());
    }
}
