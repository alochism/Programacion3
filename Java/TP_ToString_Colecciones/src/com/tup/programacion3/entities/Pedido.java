package com.tup.programacion3.entities;
import com.tup.programacion3.Calculable;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import com.tup.programacion3.enums.Estado;
import com.tup.programacion3.enums.FormaPago;

// represento un pedido hecho por un usuario
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    private Usuario usuario;
    private Set<DetallePedido> detalles; // uso Set para evitar detalles duplicados del mismo producto

    public Pedido(Usuario usuario, FormaPago formaPago) {
        super();
        this.fecha = LocalDate.now(); // la fecha se asigna automáticamente al crear el pedido
        this.estado = Estado.PENDIENTE; // todo pedido arranca en estado pendiente
        this.total = 0.0;
        this.formaPago = formaPago;
        this.usuario = usuario;
        this.detalles = new HashSet<>(); // inicializo la colección vacía
    }

    // agrego un detalle al pedido con la cantidad y el producto
    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido detalle = new DetallePedido(cantidad, producto);
        detalles.add(detalle);
        this.total += detalle.getSubtotal(); // actualizo el total del pedido
    }

    // busco un detalle por producto y lo devuelvo (o null si no existe)
    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        for (DetallePedido detalle : detalles) {
            if (detalle.getProducto().equals(producto))
                return detalle;
        }
        return null;
    }

    // elimino el detalle asociado a un producto
    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detalle = findeDetallePedidoByProducto(producto);
        if (detalle != null) {
            this.total -= detalle.getSubtotal(); // descuento el subtotal del total
            detalles.remove(detalle);
        }
    }

    // implemento calcularTotal sumando los subtotales de todos los detalles
    public void calcularTotal() {
        this.total = 0.0;
        for (DetallePedido detalle : detalles) {
            this.total += detalle.getSubtotal();
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<DetallePedido> getDetalles() {
        return detalles;
    }

    @Override
    public String toString() {
        return "Pedido{fecha=" + fecha + ", estado=" + estado + ", total=" + total +
                ", formaPago=" + formaPago + ", usuario=" + usuario.getNombre() +
                " " + usuario.getApellido() + ", detalles=" + detalles + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pedido otro = (Pedido) obj;
        return Objects.equals(getId(), otro.getId()); // dos pedidos son iguales si tienen el mismo id
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}