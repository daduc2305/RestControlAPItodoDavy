package com.example.webstudentbookspring.equipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository repo;
    public List<Todo> listTodos() {
        Iterable<Todo> todos= repo.findAll();
        return (List<Todo>) todos;
    }

    public void saveTodo(Todo todo) {
        repo.save(todo);
    }

    public Todo getTodo(int id) {
        Optional<Todo> todoOptional=repo.findById(id);
        if (todoOptional.isPresent())
            return todoOptional.get();
        else
            throw new IllegalArgumentException("Todo  non existant");
    }

    public void deleteTodo (int id) {
        repo.deleteById(id);
    }

}
