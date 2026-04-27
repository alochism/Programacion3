import { obtenerSesion, cerrarSesion } from "../../utils/auth.ts";
import { navegar } from "../../utils/navigate.ts";

/* Se protege esta ruta, si no hay sesión activa se redirije al login.
   Cualquier usuario logueado puede ver esta página sin importar su rol */

const usuario = obtenerSesion();

// Si no hay sesión, redirijo al login
if (!usuario) {
    navegar("../auth/login/index.html");
}

// Conecto el botón de cerrar sesión
const btnLogout = document.getElementById("btn-logout");

btnLogout?.addEventListener("click", () => {
    cerrarSesion();
    navegar("../auth/login/index.html");
});