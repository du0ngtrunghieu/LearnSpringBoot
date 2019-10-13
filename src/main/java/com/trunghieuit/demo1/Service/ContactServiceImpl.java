package com.trunghieuit.demo1.Service;

import com.trunghieuit.demo1.Entity.Contact;
import com.trunghieuit.demo1.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Iterable<Contact> FindAll() {
        return contactRepository.findAll();
    }
    @Override
    public List<Contact> search(String term) {
        return contactRepository.findByNameContaining(term);
    }

    @Override
    public Optional<Contact> FindOne(Integer id) {
        return contactRepository.findById(id);
    }

    @Override
    public void Save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void Delete(Integer id) {
        contactRepository.deleteById(id);
    }
}
