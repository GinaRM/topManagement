# Dog API

## Descripción

Este proyecto es una API REST que permite consumir la [API de perros](https://dog.ceo/dog-api/documentation/) y proporciona funcionalidades adicionales como autenticación JWT y manejo de razas de perros.

## Requisitos

- Java 11 o superior
- Maven

## Instalación

1. Clona el repositorio:
   ```bash
    git clone https://github.com/GinaRM/topManagement.git
    ```
2. Navega al directorio del proyecto:
   ```bash
    cd topManagement
    ```

## Configuración

1. Genera una clave secreta en base64 para JWT:
    ```java
   import java.util.Base64;
    import io.jsonwebtoken.SignatureAlgorithm;
    import io.jsonwebtoken.security.Keys;
    import java.security.Key;

    public class KeyGenerator {
        public static void main(String[] args) {
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
            String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
            System.out.println(base64Key);
        }
    }
    ```

2. Compila y ejecuta el generador de claves:
    ```bash
    javac KeyGenerator.java
    java KeyGenerator
    ```

3. Copia la clave secreta generada y añádela al archivo `application.properties`:
    ```properties
    jwt.secret=your_base64_encoded_secret_key
    ```

4. Abre el archivo `src/main/resources/application.properties` y añade la clave secreta generada:
    ```properties
    jwt.secret=your_base64_encoded_secret_key
    ```
 
## Ejecución

1. Construye y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Uso de la API

### Autenticación

#### Login

1. Abre Postman.
2. Crea una nueva solicitud.
3. Configura la solicitud con los siguientes detalles:
    - **Método**: POST
    - **URL**: `http://localhost:8080/auth/login`
    - **Encabezados**:
        - `Content-Type`: `application/json`
    - **Cuerpo**: Selecciona la opción `raw` y `JSON`, y usa el siguiente contenido:
       ```json
       {
         "username": "user1",
         "password": "password"
       }
      ```

4. Envía la solicitud. Deberías recibir una respuesta con el token JWT en el siguiente formato:
    ```json
    {
      "token": "eyJhbGciOiJIUzUxMiJ9..."
    }
    ```

### Endpoints Protegidos

#### Obtener Razas de Perros

1. Copia el token JWT de la respuesta del login.
2. Crea una nueva solicitud en Postman.
3. Configura la solicitud con los siguientes detalles:
    - **Método**: GET
    - **URL**: `http://localhost:8080/dogs/breeds`
    - **Encabezados**:
        - `Authorization`: `Bearer <your_jwt_token>`
            - Reemplaza `<your_jwt_token>` con el token que copiaste.
4. Envía la solicitud. Deberías recibir una respuesta con la lista de razas de perros en el siguiente formato:
    ```json
    {
      "message": {
        "affenpinscher": [],
        "african": [],
        "airedale": [],
        ...
     },
      "status": "success"
    }
    ```



## Autor

- [Gina Rodríguez Martínez](https://github.com/GinaRM)
