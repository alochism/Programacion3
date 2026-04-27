/* Centralizo la navegación en un solo lugar. Recibo una ruta como parámetro 
y redirijo al usuario hacia ella. */

export const navegar = (ruta: string) => {
    window.location.href = ruta;
}