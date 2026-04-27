import { loginUsuario, guardarSesion } from "../../../utils/auth.ts";
import { navegar } from "../../../utils/navigate.ts";
import { Rol } from "../../../types/Rol.ts";

/* Se pide validar las credenciales contra localStorage y guardar la sesión.
   Capturo el formulario, busco el usuario con loginUsuario() y si existe
   guardo la sesión y redirijo según su rol */

const form = document.getElementById("form-login");

form?.addEventListener("submit", (evento) => {

    // Evito que el formulario recargue la página
    evento.preventDefault();

    // Capturo los valores de los inputs
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const password = (document.getElementById("password") as HTMLInputElement).value;

    // Busco si existe un usuario con esas credenciales
    const usuario = loginUsuario(email, password);

    if (usuario) {
        // Si existe, guardo la sesión y redirijo según el rol
        guardarSesion(usuario);

        /* Se pide redirigir según el rol del usuario (uso if/else porque me parece más
        claro en este caso que el operador "?" para clarificar qué es lo que se hace) */

        if (usuario.rol === Rol.Admin) {
            navegar("../../admin/index.html");
        } else {
            navegar("../../client/index.html");
        }
    } else {
        // Si no existe, aviso al usuario 
        alert("Email o contraseña incorrectos");
    }
});
