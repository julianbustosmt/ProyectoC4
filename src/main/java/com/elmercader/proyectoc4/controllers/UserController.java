package com.elmercader.proyectoc4.controllers;

import com.elmercader.proyectoc4.entities.User;
import com.elmercader.proyectoc4.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }

    @GetMapping("/{email}/{password}")
    public User getByEmailAndPassword(@PathVariable("email") String email, @PathVariable String password){
        return service.getByEmailAndPassword(email,password);
    }

    @GetMapping("/{email}")
    public Boolean getByEmail(@PathVariable("email") String email){
        return service.getByEmail(email);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return service.update(user);
    }


}
