FROM openjdk:15
ADD target/gs-spring-boot-docker-0.1.0.jar docker-file.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "docker-file.jar"]
