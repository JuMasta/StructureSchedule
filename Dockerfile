FROM openjdk:8
EXPOSE 80
ADD target/StructuredSchedule.jar StructuredSchedule.jar
ENTRYPOINT ["java","-jar","StructuredSchedule.jar"]