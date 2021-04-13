FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ejiecrm-web-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ejiecrm-web-0.0.1-SNAPSHOT.jar"]