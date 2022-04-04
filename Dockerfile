#FROM maven:3.8.4-jdk-11 AS MAVEN_BUILD
#COPY ./ ./
#RUN mvn clean package
#FROM openjdk:11-jre-slim
#COPY --from=MAVEN_BUILD /target/UserServiceClient-0.0.1-SNAPSHOT.jar /demo.jar
#CMD ["java", "-jar", "/demo.jar"]

FROM adoptopenjdk:11-jre-hotspot
COPY target/UserServiceClient-0.0.1-SNAPSHOT.jar /demo.jar
CMD ["java","-jar","/demo.jar"]