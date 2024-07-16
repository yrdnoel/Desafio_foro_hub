# ForoHub API

ForoHub es una API RESTful para la gestión de foros en línea. Permite a los usuarios registrarse, autenticarse, y gestionar tópicos de discusión y cursos. Esta API está desarrollada usando Spring Boot y sigue las mejores prácticas de desarrollo de APIs seguras mediante el uso de JWT (JSON Web Tokens) para la autenticación.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Tokens)**
- **Hibernate/JPA**
- **MySQL**
- **Flyway**
- **Lombok**
- **Swagger (Springfox)**

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `controller`: Contiene los controladores REST que manejan las solicitudes HTTP.
  - `AutenticacionController`
  - `TopicoController`
- `domain`: Contiene las clases de dominio y repositorios.
  - `topico`
    - `Curso`
    - `DatosActualizarTopico`
    - `DatosListadoTopico`
    - `DatosRegistroTopico`
    - `DatosRespuestaTopico`
    - `Estatus`
    - `Topico`
    - `TopicoRepository`
  - `usuario`
    - `DatosAutenticacionUsuario`
    - `Usuario`
    - `UsuarioRepository`
- `infra`: Contiene configuraciones de seguridad, manejo de errores, y servicios auxiliares.
  - `errores`
    - `TratadorDeErrores`
  - `security`
    - `AutenticacionService`
    - `DatosJWTtoken`
    - `SecurityConfigurations`
    - `SecurityFilter`
    - `TokenService`
- `ForoHubApplication`: Clase principal de la aplicación.

## Instalación y Configuración

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/yrdnoel/Desafio_foro_hub.git
   cd ForoHub
   
## Configurar la Base de Datos

Crear una base de datos en MySQL llamada **foro_hub** y actualizar las credenciales en el siguiente archivo: `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/foro_hub
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

# Configuración JWT
api.security.secret=tu_clave_secreta

## Endpoints

### User Controller

#### Cambiar Contraseña
**PUT /api/users/changePassword**  
Request Body: `UserUpdatePasswordDTO`  
Response: `UserDTO`

#### Registrar Usuario
**POST /api/users**  
Request Body: `UserAddDTO`  
Response: `UserDTO`

#### Obtener Usuario
**GET /api/users/{id}**  
Response: `UserDTO`

#### Eliminar Usuario
**DELETE /api/users/{id}**  
Response: `200 OK`

### Topic Controller

#### Obtener Topic
**GET /api/topics/{id}**  
Response: `TopicDTO`

#### Actualizar Topic
**PUT /api/topics/{id}**  
Request Body: `TopicAddDTO`  
Response: `TopicDTO`

#### Eliminar Topic
**DELETE /api/topics/{id}**  
Response: `200 OK`

#### Listar Topics
**GET /api/topics**  
Response: `PageTopicDTO`

#### Crear Topic
**POST /api/topics**  
Request Body: `TopicAddDTO`  
Response: `TopicDTO`

#### Listar Respuestas de un Topic
**GET /api/topics/{id}/replies**  
Response: `PageReplyDTO`

#### Agregar Respuesta a un Topic
**POST /api/topics/{id}/replies**  
Request Body: `ReplyAddDTO`  
Response: `ReplyDTO`

#### Editar Respuesta
**PUT /api/topics/{id}/replies/{replyId}**  
Request Body: `ReplyEditDTO`  
Response: `ReplyDTO`

#### Eliminar Respuesta
**DELETE /api/topics/{id}/replies/{replyId}**  
Response: `200 OK`

### Course Controller

#### Obtener Curso
**GET /api/courses/{id}**  
Response: `CourseDTO`

#### Actualizar Curso
**PUT /api/courses/{id}**  
Request Body: `CourseAddDTO`  
Response: `CourseDTO`

#### Eliminar Curso
**DELETE /api/courses/{id}**  
Response: `200 OK`

#### Listar Cursos
**GET /api/courses**  
Response: `PageCourseDTO`

#### Registrar Curso
**POST /api/courses**  
Request Body: `CourseAddDTO`  
Response: `CourseDTO`

### Authentication Controller

#### Login
**POST /login**  
Request Body: `AuthUserDTO`  
Response: `JwtTokenDTO`

### Seguridad

La seguridad de la API se gestiona con Spring Security y JWT. Todas las solicitudes a los endpoints, excepto las de autenticación, requieren un token JWT válido. El token se debe incluir en el encabezado de la solicitud como `Authorization: Bearer <token>`.

### Migraciones de Base de Datos

Las migraciones de base de datos se gestionan con Flyway. Las migraciones se encuentran en el directorio `src/main/resources/db/migration`.


## Agradecimientos

Agradecemos a **Alura Latam** por contribuir al aprendizaje y el soporte brindado para llevar a cabo este proyecto.


