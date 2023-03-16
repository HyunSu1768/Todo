package com.todo.todo.domain.entity.Repository;

import com.todo.todo.domain.entity.Todo;
import com.todo.todo.domain.entity.TodoStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TodoService{

    private final TodoRepository todoRepository;
    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo){
        todo.setTodoStatus(TodoStatus.DOING);
        todo.setCreateTime(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id,Todo updateTodo){
        Todo findTodo = todoRepository.findById(id).orElse(null);

        findTodo.setTitle(updateTodo.getTitle());
        findTodo.setDescription(updateTodo.getDescription());

        return todoRepository.save(findTodo);

    }
    @Transactional
    public boolean deleteTodo(Long id){
        Todo todo = todoRepository.findById(id).orElse(null);
        if(todo==null){
            return false;
        }
        todoRepository.deleteById(id);
        return true;
    }

    @Transactional
    public void completeTodo(Long id){
        Todo todo = todoRepository.findById(id).orElse(null);
        todo.complete();
    }
}
