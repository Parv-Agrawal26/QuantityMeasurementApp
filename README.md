# Quantity Measurement App

A Spring Boot application for performing quantity measurements and conversions across various units including length, weight, volume, and temperature. The application features secure authentication with JWT and OAuth2 integration.

## Features

- **Unit Conversions**: Convert between different units of measurement (Length, Weight, Volume, Temperature)
- **User Authentication**: Secure login with JWT tokens and OAuth2 (Google)
- **RESTful API**: Well-documented API endpoints for measurements and user management
- **Database Integration**: MySQL database for persistent storage
- **API Documentation**: Swagger/OpenAPI documentation available at `/swagger-ui.html`

## Technologies Used

- **Java 21**
- **Spring Boot 3.2.0**
- **Spring Security** with JWT and OAuth2
- **Spring Data JPA** for database operations
- **MySQL** database
- **Maven** for dependency management
- **SpringDoc OpenAPI** for API documentation

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## Installation and Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/quantity-measurement-app.git
   cd quantity-measurement-app
   ```

2. **Set up MySQL database:**
   - Create a database named `quantitydb`
   - Update the database credentials in `src/main/resources/application.properties` if needed

3. **Configure OAuth2 (Optional):**
   - Obtain Google OAuth2 client credentials
   - Replace `YOUR_GOOGLE_CLIENT_ID` and `YOUR_GOOGLE_CLIENT_SECRET` in `application.properties`

4. **Build and run the application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Access the application:**
   - API Base URL: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`

## API Endpoints

### Authentication
- `POST /api/auth/register` - User registration
- `POST /api/auth/login` - User login
- `GET /api/auth/me` - Get current user info

### Quantity Measurements
- `POST /api/measurements/convert` - Convert quantities between units
- `GET /api/measurements/history` - Get measurement history

## Usage

### Example API Call

```bash
curl -X POST http://localhost:8080/api/measurements/convert \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -d '{
    "value": 100,
    "fromUnit": "CENTIMETER",
    "toUnit": "METER",
    "unitType": "LENGTH"
  }'
```

## Project Structure

```
src/
├── main/
│   ├── java/com/apps/quantitymeasurement/
│   │   ├── controller/          # REST controllers
│   │   ├── dto/                 # Data transfer objects
│   │   ├── entity/              # JPA entities
│   │   ├── exception/           # Exception handlers
│   │   ├── repository/          # Data repositories
│   │   ├── security/            # Security configuration
│   │   ├── service/             # Business logic
│   │   └── unit/                # Unit conversion logic
│   └── resources/
│       └── application.properties
└── test/                        # Unit tests
```
