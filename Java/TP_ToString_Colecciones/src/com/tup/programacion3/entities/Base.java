package com.tup.programacion3.entities;

import java.time.LocalDateTime;

// Clase base de la que heredan todas las entidades del proyecto
public class Base {

    private Long id;                    // identificador único del objeto
    private boolean eliminado;          // marco si el objeto fue eliminado (arranca en false)
    private LocalDateTime createdAt;    // guardo la fecha y hora de creación

    public Base() {
        this.eliminado = false;                     // al crear cualquier objeto arranca como no eliminado
        this.createdAt = LocalDateTime.now();       // capturo el momento exacto de creación
    }

    // getters y setters (permiten leer y modificar los campos desde afuera de la clase)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}