package com.tecsup.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class VistaController {

    @GetMapping("/autores-list")
    public String autoresList() {
        return "autores-list";
    }

    @GetMapping("/autor-form")
    public String autorForm() {
        return "autor-form";
    }

    @GetMapping("/publicaciones-list")
    public String publicacionesList() {
        return "publicaciones-list";
    }

    @GetMapping("/publicacion-form")
    public String publicacionForm() {
        return "publicacion-form";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
