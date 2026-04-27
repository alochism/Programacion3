import { IUser } from "../../../types/IUser.ts";
import { Rol } from "../../../types/Rol.ts";
import { registrarUsuario } from "../../../utils/auth.ts";
import { navegar } from "../../../utils/navigate.ts";

/* Capturo el formulario de registro del DOM para escuchar el evento submit.
Cuando el usuario completa el formulario, creo un objeto IUser con rol client
y lo guardo en localStorage usando registrarUsuario() */

const form = document.getElementById("form-registro");

form?.addEventListener("submit", (evento) => {

    // Evito que el formulario recargue la página
    evento.preventDefault();

    // Capturo los valores de los inputs
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const password = (document.getElementById("password") as HTMLInputElement).value;

    // Creo el objeto usuario con rol client — el TP dice que el rol no lo elige el usuario
    const nuevoUsuario: IUser = {
        email,
        password,
        rol: Rol.Client
    };

 // Guardo el usuario y redirijo al login, si el email ya existe aviso al usuario
    const registrado = registrarUsuario(nuevoUsuario);
    if (registrado) {
        navegar("../login/index.html");
    } else {
        alert("El email ya está registrado");
    }
});
