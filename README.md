# Journal Web Application

A simple journal web application built with Spring Boot. This application allows users to manage their journal entries, including adding, updating, deleting, and retrieving journal entries.

## Features

- Add new journal entries
- Retrieve all journal entries
- Retrieve journal entries by date
- Update existing journal entries
- Delete a specific journal entry
- Delete all journal entries

## Endpoints

### Get All Journal Entries

- **URL**: `/journal/all`
- **Method**: `GET`
- **Response**: A list of all journal entries.

### Add a New Journal Entry

- **URL**: `/journal/add`
- **Method**: `POST`
- **Request Body**: A `Journal` object in JSON format.
- **Response**: A success message.

### Get Journal Entries by Date

- **URL**: `/journal/date/{date}`
- **Method**: `GET`
- **Path Variable**: `date` in `yyyy-MM-dd` format.
- **Response**: A list of journal entries for the specified date.

### Update a Journal Entry

- **URL**: `/journal/{id}`
- **Method**: `PUT`
- **Path Variable**: `id` of the journal entry to update.
- **Request Body**: A `Journal` object in JSON format.
- **Response**: A success message.

### Delete a Journal Entry

- **URL**: `/journal/{id}`
- **Method**: `DELETE`
- **Path Variable**: `id` of the journal entry to delete.
- **Response**: A success message.

### Delete All Journal Entries

- **URL**: `/journal/all`
- **Method**: `DELETE`
- **Response**: A success message.


## Project Structure
```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── vikram
│   │           └── app
│   │               ├── Controller
│   │               │   └── JournalController.java
│   │               ├── Entity
│   │               │   └── Journal.java
│   │               ├── Services
│   │               │   └── JournalService.java
│   │               ├── Repository
│   │               │   └── JournalDAO.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── vikram
                └── app
                    └── JournalApplicationTests.java
  ```      

## Application Configuration

Configure your `application.properties` file with the following settings to connect your Spring Boot application to a MySQL database:

```properties
spring.application.name=app
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/journal
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
