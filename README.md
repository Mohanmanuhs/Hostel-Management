# StayEase Server

This is a server application built using IntelliJ IDEA and the Spring boot. It provides REST API endpoints for fetching, updating, deleting, and adding data to a Mysql database. The server utilizes various modern technologies including Data Jpa for Interacting with Database, JWT authentication, and JSON serialization for data handling.

## Technologies Used

- **IntelliJ IDEA**: The primary IDE for server-side Java development.
- **JSON Serialization**: For handling JSON data in the server.
- **Spring Boot**: The primary framework used for building the backend of the application, enabling rapid development with minimal configuration.
- **Spring MVC**: Provides RESTful web services and manages routing of HTTP requests.
- **Spring Data JPA**: Simplifies database operations and interaction with relational databases using the JPA specification.
- **MySQL Database**: Used for persistent storage of hostel data such as students, rooms, bookings, and staff.
- **Spring Security**: Ensures secure access with authentication and authorization mechanisms.
- **REST API**: Enables communication between the client and server, handling CRUD operations for various hostel entities
- **Lombok**: Reduces boilerplate code in model and service classes through annotations like @Getter, @Setter, and @Builder.
- **Maven/Gradle**: Manages project dependencies and build lifecycle.

####
![Screenshot from 2025-05-21 09-53-48](https://github.com/user-attachments/assets/8c0f3180-7c4e-456c-a48e-da22a33f83e6)
####
![Screenshot from 2025-05-21 09-54-21](https://github.com/user-attachments/assets/102ba277-a259-4b9f-a2b5-2b82b6b313eb)
####
![Screenshot from 2025-05-21 09-55-39](https://github.com/user-attachments/assets/52c83964-437e-4d2d-88e6-94959a97ec3d)

####

## Setup

To run this server locally, make sure you have IntelliJ IDEA installed. Clone the repository and open it in IntelliJ IDEA. Set up a Mysql Workbench and configure the connection settings in the application. Build and run the server application.

## API Endpoints

- `/hostel/getHostelDetails/id`: Fetching Hostel Details by its Id.
- `/hostel/create`: Creating new Hostel.
- `/room/addStudent`: Adding new student to room.
- More


## Contributing

If you'd like to contribute to the project, please fork the repository and create a pull request. Contributions are welcome!


## 🌐 Socials:
[![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://linkedin.com/in/mohan-h-s-6511a0254) [![X](https://img.shields.io/badge/X-black.svg?logo=X&logoColor=white)](https://x.com/@Mohan97743799) 
