package com.lesson.lesson16.webcontroller;

import com.lesson.lesson16.domain.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-valid")
public class UserValidationController
{
    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> show()
    {
        return users;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user)
    {
        users.add(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
}
