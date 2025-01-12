# Настройка на база данни с Docker и Spring Boot

Ще създадем приложение, което използва Postgres база данни, конфигурирана с Docker и управлявана със Spring Boot и Liquibase. Следвайте стъпките по-долу.

---

## Въведение

За да ползваме база данни, ще инсталираме Docker. Той пакетира приложенията и техните dependencies в преносими контейнери. Контейнерите са **лековати** (lightweight), с изолиран environment. Това позволява Docker контейнерите да бъдат деплойнати на всяка машина с инсталиран Docker, елиминирайки environment-specific проблеми.

---

## Стъпки за изпълнение

### **1. Инсталирайте Docker и Docker Compose**
Следвайте тези инструкции за инсталация:
- [Docker: Инсталация и документация](https://docs.docker.com/get-started/get-docker/)
- [Docker Desktop](https://docs.docker.com/desktop/)

---

### **2. Добавете зависимости в `build.gradle`**

```gradle
implementation 'org.springframework.boot:spring-boot-starter-web'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.postgresql:postgresql:42.7.4'
implementation 'org.liquibase:liquibase-core'
```

- **Spring Data JPA** (`spring-boot-starter-data-jpa`): За persist-ване на данни в SQL хранилища с Java Persistence API, използвайки Spring Data и Hibernate.
- **Spring Web** (`spring-boot-starter-web`): За изграждане на RESTful приложения с Spring MVC.
- **Postgres** (`mysql-connector-j`): Postgres JDBC драйвър.
- **Liquibase** (`liquibase-core`): За миграция на база данни.

---

### **3. Създайте `docker-compose.yml` в главната директория**

```yaml
version: "3.8"

services:
  db:
    build:
      context: ./docker-db  # Build the custom image from the Dockerfile in the 'docker-db' directory
    container_name: postgres-car-container
    environment:
      POSTGRES_USER: user
      POSTGRES_PASSWORD: userpassword
      POSTGRES_DB: cardb
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data  # Persist database data
    networks:
      - postgres_network
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U ${POSTGRES_USER} -d ${POSTGRES_DB} -h localhost"]
      interval: 10s
      timeout: 5s
      retries: 3

volumes:
  postgres_data:

networks:
  postgres_network:
```
---

### **4. Добавете `Dockerfile` в папка `docker-db`**

```dockerfile
# Use the official PostgreSQL image
FROM postgres:12.3

# Copy your initialization script to the PostgreSQL entrypoint directory
COPY init.sql /docker-entrypoint-initdb.d/

# Expose the PostgreSQL default port (5432)
EXPOSE 5432

---

### **5. Създайте `init.sql` в папка `docker-db` **

```sql
CREATE DATABASE cardb;
GRANT ALL PRIVILEGES ON DATABASE cardb TO "user";
```

### **6. Стартирайте базата данни**

Изпълнете следната команда:

```bash
docker-compose up
```

---

### **7. Проверете връзката с базата данни**
Можете да използвате инструменти като:
- **PgAdmin**
- **DBeaver**
- **IntelliJ IDEA Data Tool**

---

### **8. Добавете Liquibase Changelog файлове**
Създайте `liquibase_changelog.xml` в `resources/db/changelog/`.Както и `my_script_for_create_table.yaml` в `resources/db/`.:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
        xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-3.3.xsd">
    <include file="../my_script_for_create_table.yaml" relativeToChangelogFile="true"/>
</databaseChangeLog>
```

---

### **9. Конфигурирайте `application.yaml`**

```yaml
spring:
  datasource:
    url: 'jdbc:postgresql://localhost:5432/cardb' 
    driverClassName: org.postgresql.Driver
    username: 'user'
    password: 'userpassword'
  liquibase:
    change-log: classpath:/db/changelog/liquibase_changelog.xml
```

---

### **10. Създайте Entity класове**

#### Пример за `Car`:

```java
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private BigDecimal price;
}
```

#### Пример за `User`:

```java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
```

---

### **11. Създайте Repository**

#### Пример за `CarRepository`:

```java
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
```

---

### **12. Стартирайте приложението**
Уверете се, че таблиците са създадени правилно и базата работи. С Liquibase имате история на промените в базата.

---

### **13. Добавете Front-End част**
Поставете статичните файлове в директория `static/`.
cars.html -> cars.js
user.html -> users.js


### **14. Добавете Dockerfile за application-a**
```dockerfile
FROM openjdk:21
ARG JAR_FILE=build/libs/spring-car-autopark.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app.jar"]
```
In build.gradle add:
```gradle
tasks {
    bootJar {
        archiveFileName.set("${project.name}.jar")
    }
}
