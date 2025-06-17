package com.tecsup.demo.repository;

import com.tecsup.demo.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
