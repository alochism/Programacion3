package com.tup.programacion3.entities;

import java.util.Objects;

// represento el detalle de un pedido (un producto con su cantidad y subtotal)
public class DetallePedido extends Base {

    private int cantidad;
    private Double subtotal;
    private Producto producto;    // cada detalle está asociado a un producto

    public DetallePedido(int cantidad, Producto producto) {
        super();
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = producto.getPrecio() * cantidad;    // calculo el subtotal automáticamente
    }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    @Override
    public String toString() {
        return "DetallePedido{producto=" + producto.getNombre() + ", cantidad=" + cantidad + ", subtotal=" + subtotal + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DetallePedido otro = (DetallePedido) obj;
        return Objects.equals(producto, otro.producto);   // dos detalles son iguales si tienen el mismo producto
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto);
    }
}