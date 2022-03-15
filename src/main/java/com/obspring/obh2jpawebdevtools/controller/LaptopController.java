package com.obspring.obh2jpawebdevtools.controller;

import com.obspring.obh2jpawebdevtools.entities.Laptop;
import com.obspring.obh2jpawebdevtools.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    @Value("${app.message}")
    String message;

    // 1. Atributos
    private LaptopRepository laptopRepository;

    // 2. Constructores
    public LaptopController(LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }

    // CRUD

    /**
     * http://localhost:8080/api/laptops
     * @return
     */
    // Buscar todos los laptops que hay en la base de datos (ArrayLista de laptops)
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        // recuperar y devolver los laptops de base de datos
        return laptopRepository.findAll();
    }

    // Buscar un solo laptop en base de datos según su id
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo laptop en base de datos
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        return laptopRepository.save(laptop);
    }

    // Actualizar un laptop existente en base de datos
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        // actualizacion
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    // Borrar un laptop en base de datos
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.noContent().build();
        }
        // borrado
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Borrar todos los libros
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }



}
