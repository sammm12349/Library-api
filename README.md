# Library REST API

A Spring Boot REST API for managing a library book collection with CRUD operations and filtering capabilities.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Maven
- Lombok

## Features

- Create, read, update, and delete books
- Search and filter books by author, title, publisher, and page count
- Custom error handling
- RESTful API design

## API Endpoints

### Basic Operations

- `GET /books/all` - Get all books
- `GET /books/find/{id}` - Get book by ID
- `GET /books/isbn/{isbn}` - Get book by ISBN
- `POST /books/add` - Create a new book
- `PUT /books/update` - Update existing book
- `DELETE /books/delete/{id}` - Delete book

### Search & Filter

- `GET /books/search?author={author}` - Search by author
- `GET /books/search?title={title}` - Search by title
- `GET /books/publisher?publisher={name}` - Filter by publisher
- `GET /books/short?maxPages={max}` - Books under max pages
- `GET /books/long?minPages={min}` - Books over min pages
- `GET /books/pages?min={min}&max={max}` - Books in page range

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Docker
- Maven

### Running the Application

1. Clone the repository:
```bash
git clone https://github.com/sammm12349/Library-api.git
cd Library-api/librarydb
```

2. Start MySQL with Docker:
```bash
docker-compose up -d
```

The `docker-compose.yml` configuration:
```yaml
version: '3.8'
services:
  mysql:
    image: mysql:8.0
    container_name: library-mysql
    environment:
      MYSQL_DATABASE: librarydb2
      MYSQL_USER: admin
      MYSQL_PASSWORD: admin123
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3309:3306"
    volumes:
      - mysql-data:/var/lib/mysql
volumes:
  mysql-data:
```

3. Run the application:
```bash
mvn spring-boot:run
```

4. The API will be available at `http://localhost:3031/books`

## Example Request

**Create a Book:**
```bash
POST http://localhost:3031/books/add
Content-Type: application/json

{
  "title": "The Hobbit",
  "author": "J.R.R. Tolkien",
  "isbn": "978-0547928227",
  "publisher": "Houghton Mifflin",
  "pages": 310
}
```

**Search by Author:**
```bash
GET http://localhost:3031/books/search?author=Tolkien
```

## Project Structure
```
src/main/java/com/example/librarydb/
├── Controller/    # REST endpoints
├── Service/       # Business logic
├── Repo/          # Database access
├── Domain/        # Entity models
└── Exception/     # Error handling
```

## Contact

Sam Spear - [GitHub](https://github.com/sammm12349)

---

Building backend expertise with Java and Spring Boot. Open to backend development internships for Summer 2027!
