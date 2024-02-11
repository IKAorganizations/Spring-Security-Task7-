package ru.itmentor.spring.boot_security.demo.dao;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    User findByUsername(String username);


    @Query(name = "User.findAllWithRoles", value = "SELECT u FROM User u " +
    "LEFT JOIN FETCH u.roles")
    List<User> findFullRoles();

}
