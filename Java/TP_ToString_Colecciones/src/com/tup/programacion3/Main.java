package com.tup.programacion3;

import com.tup.programacion3.entities.*;
import com.tup.programacion3.enums.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // creo las 3 categorías del proyecto
        Categoria cat1 = new Categoria("Pizzas", "Pizzas artesanales con masa fresca");
        Categoria cat2 = new Categoria("Hamburguesas", "Hamburguesas gourmet con ingredientes frescos");
        Categoria cat3 = new Categoria("Bebidas", "Gaseosas, jugos y bebidas frías");

        // creo los 10 productos
        Producto p1  = new Producto("Pizza Muzzarella", 4500.0, "Pizza clásica con salsa de tomate y muzzarella derretida", 20, "pizza.jpg", true, cat1);
        Producto p2  = new Producto("Pizza Napolitana", 5200.0, "Pizza con rodajas de tomate fresco, ajo y albahaca", 15, "pizza.jpg", true, cat1);
        Producto p3  = new Producto("Pizza Especial 4 Quesos", 6800.0, "Muzzarella, provolone, roquefort y parmesano", 10, "pizza.jpg", true, cat1);
        Producto p4  = new Producto("Hamburguesa Clásica", 3800.0, "Medallón de carne, lechuga, tomate, cebolla y mayo", 30, "hamburguesa.jpg", true, cat2);
        Producto p5  = new Producto("Hamburguesa BBQ Bacon", 5100.0, "Doble medallón, bacon crocante y salsa barbacoa ahumada", 25, "hamburguesa.jpg", true, cat2);
        Producto p6  = new Producto("Hamburguesa Veggie", 4200.0, "Medallón de lentejas y garbanzo, cheddar vegano y rúcula", 0, "hamburguesa.jpg", false, cat2);
        Producto p7  = new Producto("Coca-Cola 500ml", 1200.0, "Gaseosa Coca-Cola fría, botella personal", 100, "coca.jpg", true, cat3);
        Producto p8  = new Producto("Jugo de Naranja Natural", 1800.0, "Jugo exprimido en el momento, vaso 400ml", 40, "jugo.jpg", true, cat3);
        Producto p9  = new Producto("Agua Mineral 500ml", 800.0, "Agua mineral sin gas, botella personal", 150, "agua.jpg", true, cat3);
        Producto p10 = new Producto("Pizza Fugazzeta", 5500.0, "Pizza rellena de muzzarella con cebolla caramelizada", 10, "pizza.jpg", true, cat1);

        // agrego los 10 productos a un Set
        Set<Producto> productos = new HashSet<>();
        productos.add(p1);  productos.add(p2);  productos.add(p3);
        productos.add(p4);  productos.add(p5);  productos.add(p6);
        productos.add(p7);  productos.add(p8);  productos.add(p9);
        productos.add(p10);

        // creo los 2 usuarios
        Usuario u1 = new Usuario("Dario", "Danielson", "dari@mail.com", "299234567", "dada123", Rol.USUARIO);
        Usuario u2 = new Usuario("Cecilia", "Ceciliardi", "cece@mail.com", "2999876543", "algo456", Rol.ADMIN);

        // creo los 3 pedidos y agrego detalles
        Pedido pedido1 = new Pedido(u1, FormaPago.EFECTIVO);
        pedido1.addDetallePedido(2, p1);
        pedido1.addDetallePedido(3, p7);

        Pedido pedido2 = new Pedido(u1, FormaPago.TARJETA);
        pedido2.addDetallePedido(1, p4);
        pedido2.addDetallePedido(2, p9);
        pedido2.addDetallePedido(1, p8);

        Pedido pedido3 = new Pedido(u2, FormaPago.TRANSFERENCIA);
        pedido3.addDetallePedido(2, p5);
        pedido3.addDetallePedido(1, p3);

        // muestro un producto individual
        System.out.println("=== UN PRODUCTO ===");
        System.out.println(p1);

        // muestro el listado completo de productos
        System.out.println("\n=== LISTADO DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // u1 tiene 2 pedidos y u2 tiene 1, muestro los pedidos del usuario con más pedidos
        System.out.println("\n=== PEDIDOS DEL USUARIO CON MÁS PEDIDOS (Juan Pérez) ===");
        System.out.println(pedido1);
        System.out.println(pedido2);

        // creo un producto con el mismo nombre que p1 para probar equals
        Producto pNuevo = new Producto("Pizza Muzzarella", 9999.0, "otra descripción", 1, "otra.jpg", false, cat2);
        System.out.println("\n=== COMPARACIÓN CON LA COLECCIÓN ===");
        for (Producto p : productos) {
            System.out.println("¿pNuevo equals " + p.getNombre() + "? " + pNuevo.equals(p));
        }
    }
}