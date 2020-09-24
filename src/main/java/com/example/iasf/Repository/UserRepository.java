package com.example.iasf.Repository;

import com.example.iasf.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findDistinctByName(String name);
}
