package com.tecsup.demo.controller;

import com.tecsup.demo.model.Autor;
import com.tecsup.demo.model.Publicacion;
import com.tecsup.demo.repository.AutorRepository;
import com.tecsup.demo.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        // Validar autores existentes
        List<Autor> autoresValidados = new ArrayList<>();
        if (publicacion.getAutores() != null) {
            for (Autor autor : publicacion.getAutores()) {
                autorRepository.findById(autor.getId()).ifPresent(autoresValidados::add);
            }
        }
        publicacion.setAutores(autoresValidados);
        return publicacionRepository.save(publicacion);
    }

    @GetMapping
    public List<Publicacion> listarPublicaciones() {
        return publicacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Publicacion obtenerPublicacion(@PathVariable Long id) {
        return publicacionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Publicacion actualizarPublicacion(@PathVariable Long id,
                                             @RequestBody Publicacion publicacion) {
        return publicacionRepository.findById(id).map(aux -> {
            aux.setTitulo(publicacion.getTitulo());

            List<Autor> autoresActualizados = new ArrayList<>();
            if (publicacion.getAutores() != null) {
                for (Autor autor : publicacion.getAutores()) {
                    autorRepository.findById(autor.getId()).ifPresent(autoresActualizados::add);
                }
            }
            aux.setAutores(autoresActualizados);

            return publicacionRepository.save(aux);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String eliminarPublicacion(@PathVariable Long id) {
        if (publicacionRepository.existsById(id)) {
            publicacionRepository.deleteById(id);
            return "Publicación eliminada correctamente";
        }
        return "Publicación no encontrada";
    }
}
