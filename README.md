
# Text File Statistics Application

This project is a Spring Boot application that provides statistical analysis of text files. It allows users to upload text files and view various statistics, such as word count, character count, and the frequency of each word.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:

   ```bash
   git clone [<repository-url>](https://github.com/AshishKumar225/textfilestatistics.git)
   cd textfilestatistics
   ```

2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

### Running the Application

To start the application, run the following command in the project directory:

```bash
mvn spring-boot:run
```

This will start the application on the default port `8080`. You can access the application at [http://localhost:8080](http://localhost:8080).

### Running Tests

To run the tests, execute:

```bash
mvn test
```

This will run all unit and integration tests in the project.

## Design Choices

### Architecture

- Spring Boot: The application is built using Spring Boot for its ease of setup and rapid development capabilities.
- MVC Pattern: The application follows the Model-View-Controller (MVC) pattern for separation of concerns.

### Packages

- `controller`: Contains the REST controllers, such as `FileUploadController`, which handle HTTP requests.
- `service`: Contains the service classes, such as `TextStatisticsService`, which contain the business logic.
- `model`: Contains the data models, such as `TextFileStatistics`.
- `mapper`: Contains the mappers, such as `TextFileStatisticsMapper`, which map data between layers.
- `strategy`: Contains strategy classes for different types of text analysis, such as `WordCountStrategy` and `LetterCountStrategy`.
- `context`: Contains the `TextAnalyzer` class that uses the strategy pattern to analyze text files.
- `securityConfig`: Contains security configuration classes, such as `SecurityConfig`.

### Features

- File Upload: Users can upload text files which are then processed to extract statistics.
- Statistics Display: Provides word count, character count, and word frequency analysis.
- Strategy Pattern: Different text analysis strategies are implemented using the strategy pattern.

### Configuration

- application.yml: Configuration file for Spring Boot application properties.

### Security

- Spring Security: Configured in `SecurityConfig` to secure endpoints and handle authentication and authorization.
