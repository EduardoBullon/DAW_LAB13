package com.tecsup.demo.controller;

import com.tecsup.demo.model.Genero;
import com.tecsup.demo.model.Libro;
import com.tecsup.demo.repository.GeneroRepository;
import com.tecsup.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    public String crearLibro(@RequestBody Libro libro) {
        if (libro.getGenero() == null ||
                !generoRepository.existsById(libro.getGenero().getId())) {
            throw new IllegalArgumentException("El género no existe");
        }
        libroRepository.save(libro);
        return "Libro creado correctamente";
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibro(@PathVariable Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public String actualizarLibro(@PathVariable Long id,
                                  @RequestBody Libro libro) {
        return libroRepository.findById(id).map(aux -> {
            aux.setTitulo(libro.getTitulo());
            aux.setPrecio(libro.getPrecio());
            if (libro.getGenero() != null) {
                Optional<Genero> genero =
                        generoRepository.findById(libro.getGenero().getId());
                genero.ifPresent(aux::setGenero);
            }
            libroRepository.save(aux);
            return "Libro actualizado correctamente";
        }).orElse("No se encontró el libro");
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return "Libro eliminado correctamente";
        }
        return "No se encontró el libro";
    }
}
