# API de Usuarios - Spring Boot con SQLite

## Descripción
Aplicación Spring Boot que gestiona usuarios utilizando SQLite como base de datos y JPA para la persistencia.

## Puerto
La aplicación se ejecuta en el puerto **9000**

## Endpoints Disponibles

### 1. Crear Usuario
**POST** `http://localhost:9000/api/usuarios`

**Body (JSON):**
```json
{
    "nombre": "Juan",
    "apellido": "Pérez",
    "email": "juan.perez@example.com"
}
```

**Respuesta:** Retorna el nombre y apellido en MAYÚSCULAS
```json
{
    "nombre": "JUAN",
    "apellido": "PÉREZ"
}
```

### 2. Obtener Todos los Usuarios
**GET** `http://localhost:9000/api/usuarios`

**Respuesta:**
```json
[
    {
        "id": 1,
        "nombre": "Juan",
        "apellido": "Pérez",
        "email": "juan.perez@example.com"
    }
]
```

### 3. Obtener Usuario por ID
**GET** `http://localhost:9000/api/usuarios/{id}`

Ejemplo: `http://localhost:9000/api/usuarios/1`

**Respuesta:**
```json
{
    "id": 1,
    "nombre": "Juan",
    "apellido": "Pérez",
    "email": "juan.perez@example.com"
}
```

### 4. Endpoint con Parámetros en URL
**GET** `http://localhost:9000/api/params?nombre=xxx&apellido=yyy`

Ejemplo: `http://localhost:9000/api/params?nombre=Juan&apellido=Pérez`

**Respuesta:**
```json
{
    "nombreCompleto": "Juan Pérez"
}
```

## Estructura del Proyecto

```
src/main/java/com/example/kener/
├── controller/
│   └── UsuarioController.java    # Controlador REST
├── dto/
│   ├── NombreCompletoDTO.java    # DTO para nombre completo
│   ├── UsuarioCompleteDTO.java   # DTO con todos los datos
│   ├── UsuarioCreateDTO.java     # DTO para crear usuario
│   └── UsuarioResponseDTO.java   # DTO de respuesta en mayúsculas
├── model/
│   └── Usuario.java              # Entidad JPA
├── repository/
│   └── UsuarioRepository.java    # Repositorio JPA
├── service/
│   └── UsuarioService.java       # Lógica de negocio
└── KenerApplication.java         # Clase principal
```

## Tecnologías Utilizadas
- Spring Boot 3.5.6
- Spring Data JPA
- SQLite (base de datos)
- Maven

## Cómo Ejecutar

### Compilar el proyecto:
```bash
mvnw.cmd clean install
```

### Ejecutar la aplicación:
```bash
mvnw.cmd spring-boot:run
```

La aplicación se iniciará en `http://localhost:9000`

## Pruebas con cURL

### Crear un usuario:
```bash
curl -X POST http://localhost:9000/api/usuarios -H "Content-Type: application/json" -d "{\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"email\":\"juan@example.com\"}"
```

### Obtener todos los usuarios:
```bash
curl http://localhost:9000/api/usuarios
```

### Obtener usuario por ID:
```bash
curl http://localhost:9000/api/usuarios/1
```

### Endpoint con parámetros:
```bash
curl "http://localhost:9000/api/params?nombre=Juan&apellido=Perez"
```

## Base de Datos
La base de datos SQLite se crea automáticamente en el archivo `kener.db` en la raíz del proyecto.

