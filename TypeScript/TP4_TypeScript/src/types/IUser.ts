
// Importo el Rol desde el archivo de Rol.ts para poder usarlo en la interface usuario
import { Rol } from "./Rol";

/* Creo la interface con los datos necesarios para cada usuario, y lo exporto para poder levantarlo
desde otros lugares */
export interface IUser {
    email: string;
    password: string;
    rol: Rol;
}