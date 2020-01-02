FROM openjdk:13-jdk
VOLUME /tmp
ADD target/rest-with-springboot-udemy-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]