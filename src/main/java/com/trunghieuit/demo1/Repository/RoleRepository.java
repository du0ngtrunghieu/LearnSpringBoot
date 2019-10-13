package com.trunghieuit.demo1.Repository;

import com.trunghieuit.demo1.Entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findByName(String name);
}
