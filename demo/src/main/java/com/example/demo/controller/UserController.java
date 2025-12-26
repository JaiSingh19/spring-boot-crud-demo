package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public User create(@RequestBody User user) {
        return service.save(user);
    }

    // READ ALL
    @GetMapping
    public List<User> getAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        User existing = service.findById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        return service.save(existing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "User deleted successfully";
    }
}
