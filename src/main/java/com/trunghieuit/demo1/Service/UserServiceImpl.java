package com.trunghieuit.demo1.Service;

import com.trunghieuit.demo1.Entity.Role;
import com.trunghieuit.demo1.Entity.User;
import com.trunghieuit.demo1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Iterable<User> FindAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> search(String term) {
        return (List<User>) userRepository.findByEmail(term);
    }

    @Override
    public Optional<User> FindOne(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void Save(User contact) {
        userRepository.save(contact);
    }

    @Override
    public void Delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user ==null) {
            throw new UsernameNotFoundException("Không tìm thấy User");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles){
             grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return  new org.springframework.security.core.userdetails.User(user.getEmail() , user.getPassword(),grantedAuthorities);
    }
}
