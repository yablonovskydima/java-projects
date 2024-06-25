package com.example.WebHW4.webcontroller;

import com.example.WebHW4.domain.entity.User;
import com.example.WebHW4.domain.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Operation(summary = "Get information about all users")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping()
    public List<User> show()
    {
        return userRepository.findAll();
    }

    @Operation(summary = "Add user")
    @ApiResponse(responseCode = "200", description = "Success")
    @PostMapping("/add")
    public User add(@RequestBody User user)
    {
        userRepository.save(user);
        return user;
    }

    @Operation(summary = "Edit user by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @PutMapping("/edit/{id}")
    public User edit(@PathVariable int id, @RequestBody User user)
    {
        User old = userRepository.findById(id).orElseThrow();
        old.setName(user.getName());
        old.setEmail(user.getEmail());
        old.setPassword(user.getPassword());
        old.setDateOfBirth(user.getDateOfBirth());
        userRepository.save(old);
        return old;
    }

    @Operation(summary = "Delete user by ID")
    @ApiResponse(responseCode = "200", description = "Success")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id)
    {
        userRepository.delete(userRepository.findById(id).get());
        return "User with id " + " was deleted";
    }

}
