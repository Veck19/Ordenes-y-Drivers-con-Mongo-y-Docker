package com.example.Mongo_Prueba.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Mongo_Prueba.model.Persona;

public interface PersonaRepository extends MongoRepository<Persona, String> {
}
