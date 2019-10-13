package com.trunghieuit.demo1.Service;

import com.trunghieuit.demo1.Entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Iterable<User> FindAll();
    List<User> search(String term);
    Optional<User> FindOne(Integer id);
    void Save(User contact);
    void Delete(Integer id);
    org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException;
}
