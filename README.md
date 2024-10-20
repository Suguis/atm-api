# Atm API

_NOTE: (This is a technical test for a selection process)._

This API is designed for an imaginary atm service.

## Tech stack

This application is built using:

- **Java 17**
- **Spring Boot 3.1.0**
- **Docker** for easy deployment and running

## Set up

Before you begin, ensure you have one of the following installed on your machine:

- **Docker**
- **JDK 17**

Clone the repository:

```sh
git clone https://github.com/Suguis/atm-api.git
cd atm-api
```

## Tests

You can run the application tests via Maven Wrapper.

### Maven Wrapper

```sh
chmod +x mvnw  # You could need to give it execution permisions
./mvnw clean test
```

## Running

You can run the application via Maven Wrapper or via Docker.

### Maven Wrapper

```sh
./mvnw clean spring-boot:run  # Run the application
```

### Docker

```sh
docker build . --tag 'suguis:atm-api'  # Build the image first
docker docker run -p8080:8080 'suguis:atm-api'  # Launch a container from the image built earlier
```
