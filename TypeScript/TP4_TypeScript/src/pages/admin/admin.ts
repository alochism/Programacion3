import { obtenerSesion, cerrarSesion } from "../../utils/auth.ts";
import { navegar } from "../../utils/navigate.ts";
import { Rol } from "../../types/Rol.ts";

/* Se protege esta ruta,si no hay sesión activa o el usuario no es admin,
   se redirije. Esto es el "Guard" que se solicita */

const usuario = obtenerSesion();

// Si no hay sesión, redirijo al login
if (!usuario) {
    navegar("../auth/login/index.html");
}

// Si hay sesión pero el rol no es admin, redirijo a la página de client
if (usuario && usuario.rol !== Rol.Admin) {
    navegar("../client/index.html");
}

// Conecto el botón de cerrar sesión
const btnLogout = document.getElementById("btn-logout");

btnLogout?.addEventListener("click", () => {
    cerrarSesion();
    navegar("../auth/login/index.html");
});