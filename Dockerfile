FROM openjdk:11
EXPOSE 8080
ADD target/spring-boot-movies.jar spring-boot-movies.jar
ENTRYPOINT ["java","-jar","/spring-boot-movies.jar"]