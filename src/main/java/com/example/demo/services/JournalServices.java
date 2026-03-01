package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Entity;
import com.example.demo.repository.JournalRepository;

@Component
public class JournalServices {

    @Autowired
    private JournalRepository journalRepository;

    public List<Entity> getAllJournalEntries() {
        return journalRepository.findAll();
    }

    public Entity getJournalEntryById(String id) {
        return journalRepository.findById(id).orElse(null);
    }

    public Entity createJournalEntry(Entity entity) {
        journalRepository.save(entity);
        return entity; // Placeholder return
    }

    public boolean deleteJournalEntry(String id) {
        journalRepository.deleteById(id);
        return true; // Placeholder return
    }

}
