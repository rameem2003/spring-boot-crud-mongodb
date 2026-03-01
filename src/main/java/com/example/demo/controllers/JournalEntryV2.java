package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entity;
import com.example.demo.services.JournalServices;

@RestController
@RequestMapping("/journal")
public class JournalEntryV2 {

    @Autowired
    private JournalServices journalServices;

    // private Map<Long, Entity> journalEntries = new HashMap<>();

    @GetMapping
    public List<Entity> getAll() {
        // return new ArrayList<>(journalEntries.values());
        return journalServices.getAllJournalEntries();
    }

    @GetMapping("/{id}")
    public Entity getById(@PathVariable String id) {
        // return journalEntries.get(id);
        return journalServices.getJournalEntryById(id);

    }

    @PostMapping
    public boolean create(@RequestBody Entity entity) {
        // journalEntries.put(entity.getId(), entity);
        journalServices.createJournalEntry(entity);
        return true;
    }

    @PutMapping("/{id}")
    public Entity update(@PathVariable String id, @RequestBody Entity entity) {

        Entity old = journalServices.getJournalEntryById(id);

        if (old != null) {
            old.setTitle(
                    entity.getTitle() != null && !entity.getTitle().equals("") ? entity.getTitle() : old.getTitle());
            old.setContent(entity.getContent() != null && !entity.getContent().equals("") ? entity.getContent()
                    : old.getContent());
        }
        journalServices.createJournalEntry(old);
        return old;

    }

    @DeleteMapping("/{id}")
    public boolean deleteJournal(@PathVariable String id) {
        // return journalEntries.remove(id);
        return journalServices.deleteJournalEntry(id);

    }

}
