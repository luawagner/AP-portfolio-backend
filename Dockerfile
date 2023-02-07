FROM amazoncorretto:11-alpine-jdk
MAINTAINER LAW
COPY target/law-0.0.1-SNAPSHOT.jar  law-portfolio.jar
ENTRYPOINT ["java", "-jar", "/law-portfolio.jar"]
