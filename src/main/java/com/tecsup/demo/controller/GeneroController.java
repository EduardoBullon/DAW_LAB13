package com.tecsup.demo.controller;

import com.tecsup.demo.model.Genero;
import com.tecsup.demo.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public String crearGenero(@RequestBody Genero genero) {
        generoRepository.save(genero);
        return "Género creado correctamente";
    }

    @GetMapping
    public List<Genero> listarGeneros() {
        return generoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genero buscarGenero(@PathVariable Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public String actualizarGenero(@RequestBody Genero genero, @PathVariable Long id) {
        Optional<Genero> generoOpt = generoRepository.findById(id);
        if (generoOpt.isPresent()) {
            Genero generoAux = generoOpt.get();
            generoAux.setNombre(genero.getNombre());
            generoRepository.save(generoAux);
            return "Género actualizado correctamente";
        }
        return "Género no encontrado";
    }

    @DeleteMapping("/{id}")
    public String eliminarGenero(@PathVariable Long id) {
        if (generoRepository.existsById(id)) {
            generoRepository.deleteById(id);
            return "Género eliminado correctamente";
        }
        return "Género no encontrado";
    }
}
