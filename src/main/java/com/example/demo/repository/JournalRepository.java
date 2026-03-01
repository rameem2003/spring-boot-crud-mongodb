package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.Entity;

public interface JournalRepository extends MongoRepository<Entity, String> {

}
