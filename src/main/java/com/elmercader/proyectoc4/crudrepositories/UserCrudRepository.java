package com.elmercader.proyectoc4.crudrepositories;

import com.elmercader.proyectoc4.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    @Query(value = "select  user from User user where user.email =?1 and user.password = ?2")
    public Optional<User> findByEmailAndPassword(String email,String password);

    @Query(value = "select  user from User user where user.email =?1")
    public Optional<User> findByEmail(String email);
}
