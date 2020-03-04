school-admin
=================

### Comments
Aplicación realizada con Spring MVC, Hibernate, Thymeleaf y la conexión es con una base de datos MySQL, el proyecto esta configurador para ser una imagen en Docker, se debe crear adicionalmente una imagen MySQL y recrear una bd que persista 
en un volumen creado previamente, despues debemos entrar en la consola de nuestra imagen mysql y pasar los scripts de creacion de nuestra bd, para poder funcionar correctamente debemos asignar los puertos correspondientes al aplication.yml del proyecto spring.

Por ultimo agregar que los scripts para la recreacion de la base de datos y las consultas estan en la carpeta :
```
/school-admin/src/main/resources/static/css/sql.scripts
```

### school-admin URL

https://github.com/dougblizz/school-admin.git


### Build commands:
```
./mvnw clean install dockerfile:build -Dmaven.test.skip=true
```

### Deployment:
```
docker run -t --name spring-jpa-app-container --link mysql-db:mysql -p 8080:8080 dougblizz/schooladmin
```
"spring-jpa-app-container" es el nombre del container asi que puede ser random.

"mysql-db" es el contenedor de la imagen mysql

"dougblizz/schooladmin" el repositorio del app

### API Urls:
```
[GET] http://localhost:8080/welcome
```
