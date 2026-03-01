package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Entity;

@RestController
@RequestMapping("/journal_")
public class JournalEntry {
    private Map<Long, Entity> journalEntries = new HashMap<>();

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public List<Entity> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/{id}")
    public Entity getById(@PathVariable Long id) {
        return journalEntries.get(id);

    }

    @PostMapping
    public boolean create(@RequestBody Entity entity) {
        journalEntries.put(entity.getId(), entity);
        return true;
    }

    @DeleteMapping("/{id}")
    public Entity deleteJournal(@PathVariable Long id) {
        return journalEntries.remove(id);

    }

}
