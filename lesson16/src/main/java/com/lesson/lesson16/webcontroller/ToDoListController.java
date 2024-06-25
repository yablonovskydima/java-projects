package com.lesson.lesson16.webcontroller;

import com.lesson.lesson16.domain.entity.Task;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/to-do-list")
public class ToDoListController
{
    private List<Task> tasks = new ArrayList<>();
    @GetMapping
    public List<Task> showTasks()
    {
        return tasks;
    }

    @PostMapping
    public ResponseEntity<String> addTask(@Valid  @RequestBody Task task, BindingResult bindingResult)
    {
        tasks.add(task);
        return new ResponseEntity<>("Task added successfully", HttpStatus.OK);
    }
}
