import type { IUser } from "../types/IUser.ts";

/* Reviso el array de usuarios guardados en localStorage, si no existe el array está vacío.
Uso push para agregar usuarios en el array y lo guardo actualizado en el localStorage */

export const registrarUsuario = (nuevoUsuario: IUser): boolean => {
    // Leo los usuarios existentes, si no hay ninguno arranco con array vacío
    const usuariosGuardados = localStorage.getItem("users");
    const usuarios: IUser[] = usuariosGuardados ? JSON.parse(usuariosGuardados) : [];

    // Verifico que no exista un usuario con el mismo email
    const existe = usuarios.find((u) => u.email === nuevoUsuario.email);
    if (existe) return false;

    // Agrego el nuevo usuario y guardo el array actualizado
    usuarios.push(nuevoUsuario);
    localStorage.setItem("users", JSON.stringify(usuarios));
    return true;
}

/* Busco en el array de usuarios si existe alguno que coincida con el email 
y password recibidos. Retorno el usuario si lo encuentro, o null si no existe */

export const loginUsuario = (email: string, password: string): IUser | null => {

    // Leo los usuarios guardados, si no hay ninguno retorno null
    const usuariosGuardados = localStorage.getItem("users");
    if (!usuariosGuardados) return null;

    // Busco si existe alguno que coincida con email y password
    const usuarios: IUser[] = JSON.parse(usuariosGuardados);
    return usuarios.find((u) => u.email === email && u.password === password) ?? null;
}

/* Guardo el usuario logueado en localStorage bajo la clave "userData" 
para mantener la sesión activa */
export const guardarSesion = (usuario: IUser): void => {
    localStorage.setItem("userData", JSON.stringify(usuario));
}

/* Leo el usuario activo desde localStorage. Retorno el usuario si hay sesión activa,
o null si no hay ninguna. Esto se hace para proteger los datos, si no sé que usuario está
 logueado no tengo la información suficiente para los permisos de */

export const obtenerSesion = (): IUser | null => {
    const userData = localStorage.getItem("userData");
    return userData ? JSON.parse(userData) : null;
}

/* Elimino la sesión activa borrando "userData" del localStorage.
Sin sesión, el usuario queda deslogueado y las rutas protegidas lo redirigen al login */

export const cerrarSesion = (): void => {
    localStorage.removeItem("userData");
}