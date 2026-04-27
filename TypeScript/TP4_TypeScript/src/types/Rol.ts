/* Estoy creando un Enum llamado Rol que define los únicos dos roles 
posibles en mi sistema. Lo exporto para poder usarlo en otros archivos. 
Cada valor del Enum tiene un nombre legible en el código (Admin, Client) 
y un valor string real que se va a guardar en el localStorage ("admin", "client"). 
Esto me garantiza que en ningún lugar del proyecto voy a poder asignar un rol inválido por error. */

export enum Rol {
    Admin = "admin",
    Client = "client"
}