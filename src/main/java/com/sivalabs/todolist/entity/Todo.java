package com.sivalabs.todolist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="todos")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Todo implements Serializable {
    @Id
    @SequenceGenerator(name = "todo_id_generator", sequenceName = "todo_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "todo_id_generator")
    private Long id;

    @Column(nullable=false)
    @NotEmpty
    private String content;

    @JsonProperty("created_at")
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
