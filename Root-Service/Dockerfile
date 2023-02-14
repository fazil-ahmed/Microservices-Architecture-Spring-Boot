FROM tomcat:8.0.51-jre8-alpine AS build
MAINTAINER Fazil Ahmed Hakeem (fazil1997ahmed@gmail.com)

# Install Java.
RUN apk --update --no-cache add openjdk8 curl
RUN apk add maven

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/default-jvm/

COPY src /usr/local/service/src
COPY pom.xml /usr/local/service
RUN mvn -f /usr/local/service/pom.xml clean install -DskipTests

FROM openjdk:8
EXPOSE 8081
COPY --from=build /usr/local/service/target/Root-Service-0.0.1-SNAPSHOT.jar Root-Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Root-Service-0.0.1-SNAPSHOT.jar"]
