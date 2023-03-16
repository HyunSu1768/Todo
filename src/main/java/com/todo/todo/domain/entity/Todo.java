package com.todo.todo.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;

    @CreatedDate
    private LocalDateTime createTime;
    @Enumerated(EnumType.STRING)
    private TodoStatus todoStatus;

    public void complete(){
            this.setTodoStatus(TodoStatus.COMPLETE);
    }
}
