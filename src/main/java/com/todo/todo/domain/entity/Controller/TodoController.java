package com.todo.todo.domain.entity.Controller;

import com.todo.todo.domain.entity.Repository.TodoService;
import com.todo.todo.domain.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todolist")
    public List<Todo> getTodoList(){
        return todoService.findAll();
    }

    @PostMapping("/createTodo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}/edit")
    public Todo updateTodo(@PathVariable Long id,@RequestBody Todo todo){
        return todoService.updateTodo(id,todo);
    }

    @DeleteMapping("/{id}/delete")
    public boolean deleteTodo(@PathVariable Long id){
        return todoService.deleteTodo(id);
    }

    @PostMapping("/{id}/complete")
    public void completeTodo(@PathVariable("id") Long id){
        todoService.completeTodo(id);
    }

}
