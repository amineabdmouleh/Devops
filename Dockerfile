FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:admin -o achat.jar "http://192.168.43.17:8081/repository/maven-releases/tn/esprit/spring/1.0/voyage-1.0.jar" -L
ENTRYPOINT ["java","-jar","/voyage.jar"]
EXPOSE 8089