package com.elmercader.proyectoc4.repositories;

import com.elmercader.proyectoc4.crudrepositories.UserCrudRepository;
import com.elmercader.proyectoc4.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository repository;

    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }

    public Optional<User> getByEmailAndPassword(String email, String password){
        return(repository.findByEmailAndPassword(email, password));
    }

    public Optional<User> getByEmail(String email){
        return repository.findByEmail(email);
    }

    public  Optional<User> getById(int id){
        return repository.findById(id);
    }

    public User save(User user){
        return repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }
}
