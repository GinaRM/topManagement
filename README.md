# Dog API

## Description

This project is a REST API that consumes the [Dog API](https://dog.ceo/dog-api/documentation/) and provides additional functionalities such as JWT authentication and dog breed management.

## Requirements

- Java 11 or higher
- Maven

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/GinaRM/topManagement.git
   ```
2. Navigate to the project directory:
   ```bash
   cd topManagement
   ```

## Configuration

1. Generate a base64-encoded secret key for JWT:
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

2. Compile and run the key generator:
    ```bash
    javac KeyGenerator.java
    java KeyGenerator
    ```

3. Copy the generated secret key and add it to the `application.properties` file:
    ```properties
    jwt.secret=your_base64_encoded_secret_key
    ```

4. Open the file `src/main/resources/application.properties` and add the generated secret key:
    ```properties
    jwt.secret=your_base64_encoded_secret_key
    ```

## Execution

1. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## API Usage

### Authentication

#### Login

1. Open Postman.
2. Create a new request.
3. Configure the request with the following details:
    - **Method**: POST
    - **URL**: `http://localhost:8080/auth/login`
    - **Headers**:
        - `Content-Type`: `application/json`
    - **Body**: Select `raw` and `JSON` options, and use the following content:
       ```json
       {
         "username": "user1",
         "password": "password"
       }
       ```

4. Send the request. You should receive a response with the JWT token in the following format:
    ```json
    {
      "token": "eyJhbGciOiJIUzUxMiJ9..."
    }
    ```

### Protected Endpoints

#### Get Dog Breeds

1. Copy the JWT token from the login response.
2. Create a new request in Postman.
3. Configure the request with the following details:
    - **Method**: GET
    - **URL**: `http://localhost:8080/dogs/breeds`
    - **Headers**:
        - `Authorization`: `Bearer <your_jwt_token>`
            - Replace `<your_jwt_token>` with the token you copied.
4. Send the request. You should receive a response with the list of dog breeds in the following format:
    ```json
    {
      "message": {
        "affenpinscher": [],
        "african": [],
        "airedale": []
      },
      "status": "success"
    }
    ```

## Author

- [Gina Rodríguez Martínez](https://github.com/GinaRM)
