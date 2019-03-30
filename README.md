### Mysql database setup

```
CREATE USER 'rest_user'@'localhost' IDENTIFIED BY 'rest_password';
CREATE DATABASE `rest_db`;
GRANT ALL PRIVILEGES ON rest_db. * TO 'rest_user'@'localhost';
```

To create tables and populate them with initial data you need to uncomment one line in
`application.properties` file:
```
# spring.datasource.initialization-mode=always
```

### Test task endpoints

`GET http://localhost:9090/students/{firstNameOrLastName)` - search students

`POST http://localhost:9090/students` - create new student
```
Body example:
{
    "firstName": "Hello",
    "lastName": "Kitty",
    "age": "33",
    "gender": "male"
}
```