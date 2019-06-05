school-admin
=================

### Comments
Aplicación realizada con Spring Boot, Hibernate, Thymeleaf y la conexión es con una base de datos MySQL. Quería el proyecto con la configuración para estar en contenido en docker pero tengo al parecer problemas con mi jar que dice que esta corrupto o es invalido, dejo el la configuración que tenia en el pom cuando intente correr la imagen (este plugin no esta en el codigo original):

```
<plugin>
	<groupId>com.spotify</groupId>
	<artifactId>docker-maven-plugin</artifactId>
	<configuration>
		<imageName>schooladmin</imageName>
		<baseImage>java:8</baseImage>
		<entryPoint>["java", "-jar", "/${project.build.finalName}.jar"]</entryPoint>
		<resources>
		  <resource>
			<targetPath>/</targetPath>
			<directory>${project.build.directory}</directory>
			<include>${project.build.finalName}.jar</include>
		  </resource>
		</resources>
	</configuration>
</plugin>
```

Po ultimo agregar que los scripts para la recreacion de la base de datos y las consultas estan en la carpeta:
```
/school-admin/src/main/resources/static/css/sql.scripts
```

### school-admin URL

https://github.com/dougblizz/school-admin.git


### Build commands:
```
mvn clean package
```

### Deployment:

standalone

### API Urls:
```
[GET] http://localhost:8080/welcome
```
