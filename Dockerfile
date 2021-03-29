FROM java:8
EXPOSE 8001
ADD ./target/course-service-0.0.1-SNAPSHOT.jar course-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","course-service-0.0.1-SNAPSHOT.jar"]