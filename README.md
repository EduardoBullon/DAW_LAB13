# 📚 Sistema de Publicaciones - Spring Boot + PostgreSQL

Este proyecto es una aplicación web desarrollada con Spring Boot, PostgreSQL y Thymeleaf que permite gestionar autores y publicaciones. Incluye una API REST para operaciones CRUD y una interfaz web conectada mediante llamadas `fetch`.

## 🔗 Deploy

La aplicación está desplegada y disponible en:

👉 [https://mi-sistema-publicaciones.onrender.com](https://mi-sistema-publicaciones.onrender.com)

## ⚙️ Tecnologías

- Java 17
- Spring Boot 3.5
- PostgreSQL
- Thymeleaf
- Bootstrap 5
- Render (para despliegue)

## 🚀 Funcionalidades

- Crear, leer, actualizar y eliminar autores
- Crear, leer, actualizar y eliminar publicaciones
- Relación muchos a muchos entre publicaciones y autores
- API REST accesible desde Postman o cualquier cliente HTTP
- Interfaz web dinámica utilizando `fetch` para consumir la API

## 📂 Estructura

- `/api/autores` – Endpoints REST para autores
- `/api/publicaciones` – Endpoints REST para publicaciones
- `/templates` – Ruta para acceder a las vistas del frontend

---

Desarrollado para fines académicos – DAW, Semana 13 ✨
