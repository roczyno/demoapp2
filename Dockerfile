FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/demo2-0.0.1-SNAPSHOT.jar DemoApp2.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","DemoApp2.jar"]
