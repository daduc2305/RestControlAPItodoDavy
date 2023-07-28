package com.example.webstudentbookspring.equipe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TodoController {
TodoService service;
    @Autowired
    public TodoController(TodoService service) {this.service= service; }

    @GetMapping("/todo")
    public List<Todo> listTodos(){
        List<Todo> todos = service.listTodos();
        return todos;
    }
    @GetMapping("/info")
    public String gitInfo(){
        return "retourn dd";
    }

    @PostMapping("/todo")
    public void saveTodo(@RequestBody Todo todo){
       service.saveTodo(todo);
    }

    @PutMapping ("/todo/{todoId}")
    public void updateTodo(@PathVariable("todoId")int id, @RequestBody Todo todo){
        Todo todo1 = service.getTodo(id);
        if (todo1 !=null) {
            todo.setId(id);
            service.saveTodo(todo);
        }
    }

    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable("todoId") int id){
        return  service.getTodo(id);
    }

    @DeleteMapping ("/todo/{todoId}")
    public void  deleteTodo(@PathVariable("todoId")int id){
        service.deleteTodo(id);
    }

}



