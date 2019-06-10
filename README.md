school-admin
=================

### Comments
Aplicación realizada con Spring MVC, Hibernate, Thymeleaf y la conexión es con una base de datos MySQL, el proyecto esta configurador para ser una imagen en Docker, se debe crear adicionalmente una imagen MySQL y recrear una bd que persista 
en un volumen creado previamente para poder funcionar correctamente debemos asignar los puertos correspondientes al aplication.yml del proyecto.

Por ultimo agregar que los scripts para la recreacion de la base de datos y las consultas estan en la carpeta:
```
/school-admin/src/main/resources/static/css/sql.scripts
```

### school-admin URL

https://github.com/dougblizz/school-admin.git


### Build commands:
```
./mvnw clean package
```

### Deployment:

standalone

### API Urls:
```
[GET] http://localhost:8080/welcome
```
