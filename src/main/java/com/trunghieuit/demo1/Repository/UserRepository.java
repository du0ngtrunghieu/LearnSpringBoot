package com.trunghieuit.demo1.Repository;

import com.trunghieuit.demo1.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmail(String email);
}
