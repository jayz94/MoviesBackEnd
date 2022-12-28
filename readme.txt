repo: https://mvnrepository.com/
https://www.arquitecturajava.com/spring-boot-starter-un-concepto-fundamental/

para agregar swagger: https://exceptionly.com/2022/02/09/swagger-2-with-spring-boot/
-application.properties
spring.mvc.pathmatch.matching-strategy=ANT_PATH_MATCHER
-se agrega: springFoxConfig.class
-se agrega en build.gradle
	implementation "io.springfox:springfox-swagger2:3.0.0"
	implementation "io.springfox:springfox-swagger-ui:3.0.0"
	implementation "io.springfox:springfox-boot-starter:3.0.0"
-se levanta mediante: http://localhost:8080/swagger-ui/index.html

###############
#para docker
* agregamos en la raiz el archivo Dockerfile
*vamos a la pestaña maven luego excecute maven goal->mvn packages y se genera el .jar en /target
* despues de </plugins en pom.xml agregamos
<finalName>spring-boot-movies</finalName>
* vamos a la raiz del proyecto y ejecutamos docker build -t springboot-movie:lastest .
* docker run -p 8080:8081 idImage

######################
swagger2
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
</dependency>

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.6.4</version>
</dependency>

para acceder a la documentacion: http://localhost:8080/api-docs/
http://localhost:8080/api/swagger-ui/index.html

//datos para logg
<dependency>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
</dependency>
@Slf4j
public class Prueba {
	void test() {
log.info("Entrando al método test");
	}
}
************************ BD
url para conectarme a la bd de mi pc
jdbc:mysql://host.docker.internal:3306/movies?useSSL=true&serverTimezone=Europe/Madrid

