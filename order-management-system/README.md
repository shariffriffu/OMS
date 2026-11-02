# Order Management System (OMS)

A Spring Boot RESTful API service for managing customers and service orders.

## Tech Stack
- **Java 17**
- **Spring Boot 4.x** (Spring Data JPA, Spring Web MVC)
- **PostgreSQL**
- **Lombok**
- **Maven**

## Features
- **Customer Management**: Register, view, and query customers by email or ID.
- **Service Order Management**: Create and track service orders with automatic order number generation and status tracking.
- **Global Error Handling**: Standardized error responses using `@RestControllerAdvice` and custom `ResourceNotFoundException`.

## REST API Endpoints

### Customers (`/api/customers`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/customers` | Create a new customer |
| `GET` | `/api/customers` | Get all customers |
| `GET` | `/api/customers/{id}` | Get customer by ID |
| `GET` | `/api/customers/email/{email}` | Get customer by email |

### Service Orders (`/api/orders`)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/api/orders` | Create a new service order |
| `GET` | `/api/orders` | Get all service orders |
| `GET` | `/api/orders/{id}` | Get order by ID |
| `GET` | `/api/orders/subscriber/{subscriberId}` | Get orders by subscriber ID |
| `GET` | `/api/orders/status/{status}` | Get orders filtered by status |

## Getting Started

### Prerequisites
- Java 17+
- PostgreSQL database named `oms_database`

### Running the Application
```bash
./mvnw spring-boot:run
```
