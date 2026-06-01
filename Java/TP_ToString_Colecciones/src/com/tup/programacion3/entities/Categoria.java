package com.tup.programacion3.entities;

import java.util.Objects;

// represento una categoría a la que pueden pertenecer los productos
public class Categoria extends Base {

    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        super();                         // llamo al constructor de Base para inicializar id, eliminado y createdAt
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Categoria{nombre=" + nombre + ", descripcion=" + descripcion + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria otra = (Categoria) obj;
        return Objects.equals(nombre, otra.nombre);   // dos categorías son iguales si tienen el mismo nombre
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);   // genero el hash basándome en el nombre
    }
}