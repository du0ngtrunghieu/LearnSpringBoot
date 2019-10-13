package com.trunghieuit.demo1.Service;

import com.trunghieuit.demo1.Entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactService{
    Iterable<Contact> FindAll();
    List<Contact> search(String term);
    Optional<Contact> FindOne(Integer id);
    void Save(Contact contact);
    void Delete(Integer id);

}
