# TP5 - ToString, Equals, HashCode y Colecciones

**Alumno:** Matías Alochis  
**Universidad:** Universidad Tecnológica Nacional (UTN)  
**Tecnicatura:** Tecnicatura Universitaria en Programación a Distancia  
**Materia:** Programación III  

---

## Descripción

Trabajo Práctico sobre implementación de `toString()`, `equals()`, `hashCode()` y colecciones de tipo `Set` en Java.

Se desarrolló el modelo de datos de una aplicación de pedidos (Food Store) a partir de un diagrama UML, respetando tipos de datos, relaciones y multiplicidad.

## Estructura del proyecto

- **entities:** `Base`, `Categoria`, `Producto`, `Usuario`, `DetallePedido`, `Pedido`
- **enums:** `Rol`, `Estado`, `FormaPago`
- **interfaz:** `Calculable`
- **Main:** instanciación de objetos y demostración de los métodos implementados

## Conceptos aplicados

- Herencia (`extends`) y uso de clase base común
- Implementación de interfaz (`implements Calculable`)
- Sobrescritura de `toString()` en todas las entidades
- Sobrescritura de `equals()` y `hashCode()` con criterios de identidad definidos por entidad
- Colecciones `HashSet<T>` para evitar duplicados en productos y detalles de pedido
- Instanciación y comparación de objetos mediante `equals()` contra una colección