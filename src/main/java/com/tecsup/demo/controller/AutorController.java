package com.tecsup.demo.controller;

import com.tecsup.demo.model.Autor;
import com.tecsup.demo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutor(@PathVariable Long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        return autorRepository.findById(id).map(a -> {
            a.setNombre(autor.getNombre());
            return autorRepository.save(a);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String eliminarAutor(@PathVariable Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return "Autor eliminado correctamente";
        }
        return "Autor no encontrado";
    }
}
