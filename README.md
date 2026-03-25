# Bill of Materials (BOM) Application

Esta aplicación es un sistema de gestión de listas de materiales (BOM) para productos, desarrollado con Spring Boot. Permite crear productos, agregar materiales a ellos y calcular los requerimientos de producción.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.5.12**
- **H2 Database** (base de datos en memoria)
- **Maven** (gestión de dependencias)
- **Lombok** (para reducir código boilerplate)

## Requisitos Previos

- Java 17 instalado
- Maven 3.6+ instalado

## Cómo Ejecutar el Proyecto

1. **Clonar o descargar el proyecto**:
   ```
   git clone <url-del-repositorio>
   cd msv-quanta-bom
   ```

2. **Compilar el proyecto**:
   ```
   mvn clean compile
   ```

3. **Ejecutar la aplicación**:
   ```
   mvn spring-boot:run
   ```

   La aplicación se ejecutará en `http://localhost:8080`.

## Base de Datos H2

La aplicación utiliza H2 como base de datos en memoria. No requiere configuración adicional.

- **Consola H2**: Accede a `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Usuario**: `sa`
- **Contraseña**: (vacía)

Los datos se pierden al reiniciar la aplicación.

## Endpoints de la API

### Productos

- **POST /products**: Crear un nuevo producto.
  - Body: `{"name": "Nombre del producto"}`
  - Respuesta: ID del producto creado (200 OK)

- **POST /products/{id}/materials**: Agregar un material a un producto.
  - Body: `{"material": "Nombre del material", "quantity": 1}`
  - Respuesta: 200 OK (sin contenido)

### Producción

- **GET /production/calculate?productId={id}&quantity={qty}**: Calcular requerimientos de producción.
  - Respuesta: Detalles de los materiales necesarios (200 OK)

## Validaciones y Manejo de Errores

- La aplicación incluye validaciones en los DTOs de entrada (@NotBlank, @Min).
- Manejo global de excepciones para errores de validación (400), productos no encontrados (404), materiales duplicados (409), etc.
- Respuestas de error en formato JSON estandarizado.

## Uso con Postman

Se incluye una colección de Postman en `src/main/resources/static/quanta-bom.postman_collection.json`.

1. Importa la colección en Postman.
2. Configura la variable `local_url` a `http://localhost:8080` (ya está configurada por defecto).
3. Ejecuta las requests en orden:
   - Crear producto
   - Agregar materiales
   - Calcular producción

## Arquitectura

El proyecto sigue una arquitectura hexagonal (puertos y adaptadores):

- **Domain**: Modelos de negocio, puertos de entrada/salida, excepciones.
- **Application**: Casos de uso.
- **Infrastructure**: Adaptadores para persistencia, web, configuración.

## Pruebas

Ejecuta las pruebas con:
```
mvn test
```

## Notas Adicionales

- La aplicación está configurada para desarrollo con H2. Para producción, cambiar a una base de datos persistente.
- Los logs se muestran en la consola al ejecutar.</content>
<parameter name="filePath">C:\Users\steve\Desktop\Revision\msv-quanta-bom\README.md
