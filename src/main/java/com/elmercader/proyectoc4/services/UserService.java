package com.elmercader.proyectoc4.services;

import com.elmercader.proyectoc4.entities.User;
import com.elmercader.proyectoc4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getById(int id) {
        Optional<User> user = repository.getById(id);
        return user.orElse(null);
    }

    public User getByEmailAndPassword(String email, String password) {
        Optional<User> user = repository.getByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            User u = new User();
            u.setEmail(email);
            u.setPassword(password);
            u.setName("NO DEFINIDO");
            return u;
        }
    }

    public Boolean getByEmail(String email){
        Optional<User> user = repository.getByEmail(email);
        return(user.isPresent());
    }

    public User save(User user) {
        return repository.save(user);
    }

    public boolean delete(int id) {
        Boolean response = repository.getById(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
        return response;
    }

    public User update(User user){
        if (user.getId() != null){
            Optional<User> existUser = repository.getById(user.getId());
            if (existUser.isPresent()){
                if (user.getEmail() != null) {
                    existUser.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    existUser.get().setPassword(user.getPassword());
                }
                if (user.getName() != null){
                    existUser.get().setName(user.getName());
                }
                return repository.save(existUser.get());
            }
        }
        return user;
    }
}
