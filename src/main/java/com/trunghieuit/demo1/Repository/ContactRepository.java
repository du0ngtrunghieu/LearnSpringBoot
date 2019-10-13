package com.trunghieuit.demo1.Repository;

import com.trunghieuit.demo1.Entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ContactRepository extends CrudRepository<Contact , Integer> {
    List<Contact> findByNameContaining(String term);

}
