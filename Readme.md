# Тестовое задание Центр Цифрового Развития

### Технологии

* Spring Boot, Spring Web, Spring Data
* PostgresSQL, Hibernate, Liquibase
* OpenAPI

### Что реализовано
#### Технически:
* CRUD сущностей новости, типы новостей
* Связи между сущностями
* Миграция Liquibase
* Dockerfile и docker-compose

### Запуск с помощью docker

Запуск с помощью docker: `docker-compose -p cifra up`. Файл docker-compose.yml:

```
version: '4'
services:
  client-backend:
    image: m7only/cifra:0.0.1
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    depends_on:
      - service-db
    environment:
      - SERVER_PORT= 8080
      - SPRING_DATASOURCE_URL=jdbc:postgresql://service-db/cifra

  service-db:
    image: postgres:14.7-alpine
    environment:
      POSTGRES_DB: cifra
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: root
    ports:
      - "15432:5432"
    volumes:
      - db-data:/var/lib/postgresql/data
    restart: unless-stopped

volumes:
  db-data:
```

### Запуск с помощью IDE
Перед запуском в IDE необходимо внести изменения в application.properties в части подключения к базе данных (сервер, бд, пользователь, пароль) в соответствии с вашими настройками. В приложении по умолчанию настройки следующие:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/cifra_k
spring.datasource.username=postgres
spring.datasource.password=root
```

### Тестирование

Протестировать можно с помощью OpenAPI после запуска через IDE или docker: `http://localhost:8080/swagger-ui/index.html`

### Задание

Написать REST API бэкенд со следующим функционалом:
Сохранение в БД Новостей и их Типов.
Новость должна иметь структуру:

* Имя;
* Краткое описание;
* Полное описание;
* Тип новости;
Тип новостей должен иметь структуру:
* Имя типа;
* Цвет типа.

Нужен функционал:

* CRUD (Create, Read, Update, Delete) типов новостей;
* CRUD новостей;
* Возможность получить список всех новостей (имя, краткое описание, тип новости – имя типа, цвет типа);
* Возможность получить список новостей определенного типа;
* Возможность получить список всех типов новостей.

Для написания программы необходимо использовать Spring boot framework. Для работы с БД необходимо использовать spring-data-jpa.
Готовый результат необходимо выложить в Git. ПО должно собираться и быть работоспособным для проверки. Плюсом будет если вы его соберете в docker.


2024