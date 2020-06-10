FROM openjdk:11
EXPOSE 80
ADD target/StructuredSchedule.jar StructuredSchedule.jar
ENTRYPOINT ["java","-jar","StructuredSchedule.jar"]