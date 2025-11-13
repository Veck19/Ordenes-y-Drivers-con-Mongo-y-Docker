package com.example.Mongo_Prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mongo_Prueba.model.Persona;
import com.example.Mongo_Prueba.repository.PersonaRepository;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> listarPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPorId(String id) {
        return personaRepository.findById(id);
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona actualizarPersona(String id, Persona personaActualizada) {
        return personaRepository.findById(id)
                .map(p -> {
                    p.setNombre(personaActualizada.getNombre());
                    p.setEdad(personaActualizada.getEdad());
                    p.setCiudad(personaActualizada.getCiudad());
                    return personaRepository.save(p);
                })
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
    }

    public void eliminarPersona(String id) {
        personaRepository.deleteById(id);
    }
}
