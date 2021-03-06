package org.example.RestAPI.controller;

import org.example.RestAPI.model.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestAPIController {
    private List<Todo> list = new ArrayList<>();

    @PostConstruct
    public void init(){
        list.add(new Todo("title 1", "content 1"));
        list.add(new Todo("title 2", "content 2"));
        list.add(new Todo("title 3", "content 3"));
        list.add(new Todo("title 4", "content 4"));
        list.add(new Todo("title 5", "content 5"));
        list.add(new Todo("title 6", "content 6"));
    }

    @GetMapping("/todo")
    public List<Todo> getTodoList(){
        return list;
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name="todoId") Integer todoId){
        return list.get(todoId-1);
    }

    @PutMapping("/todo/{todoId}")
    public Todo editTodo(@PathVariable(name="todoId") Integer todoId, @RequestBody Todo todo){
        list.set(todoId, todo);
        return todo;
    }

    @PostMapping("/todo")
    public ResponseEntity addTodo(@RequestBody Todo todo){
        list.add(todo);
        return ResponseEntity.ok().body(todo);
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable(name="todoId") Integer todoId){
        list.remove(todoId.intValue());
        return ResponseEntity.ok().build();
    }
}
