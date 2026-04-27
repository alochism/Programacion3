import { obtenerSesion } from "./utils/auth.ts";
import { navegar } from "./utils/navigate.ts";
import { Rol } from "./types/Rol.ts";

/* Se pide centralizar la protección de rutas en main.ts.
   Intercepto la carga de la página y verifico la sesión del usuario
   para redirigirlo según su rol o enviarlo al login si no hay sesión */

const usuario = obtenerSesion();
const rutaActual = window.location.pathname;

// Si no hay sesión y no está en login o registro, redirijo al login
if (!usuario && !rutaActual.includes("login") && !rutaActual.includes("registro")) {
    navegar("/src/pages/auth/login/index.html");
}

// Si hay sesión y está en login o registro, redirijo según su rol
if (usuario && (rutaActual.includes("login") || rutaActual.includes("registro"))) {
    if (usuario.rol === Rol.Admin) {
        navegar("/src/pages/admin/index.html");
    } else {
        navegar("/src/pages/client/index.html");
    }
}