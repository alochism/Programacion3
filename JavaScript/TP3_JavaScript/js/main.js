function cargarCategorias() {
    const lista = document.getElementById("lista-categorias");
    categorias.forEach(function (categoria) {

        const item = document.createElement("li");

        const enlace = document.createElement("a");
        enlace.href = "#";
        enlace.textContent = categoria;
        item.appendChild(enlace);
        lista.appendChild(item);

    });
}

cargarCategorias();

function cargarProductos() {
    const contenedor = document.getElementById("contenedor-productos");

    productos.forEach(function (producto) {
        const tarjeta = document.createElement("article");

        tarjeta.innerHTML = `
    <img src="${producto.imagen}" alt="${producto.nombre}">
    <h3>${producto.nombre}</h3>
    <p>${producto.descripcion}</p>
    <p>Precio: <strong>$${producto.precio}</strong></p>
    <button type="button">Ver Detalles</button>
    <button type="button" onclick="alert('Agregaste: ${producto.nombre}')">Agregar al Carrito</button>
`;

        contenedor.appendChild(tarjeta);

    });
}
cargarProductos();

