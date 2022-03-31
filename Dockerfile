FROM adoptopenjdk/openjdk11:ubi
COPY build/libs/*.jar raccoonapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/raccoonapp.jar"]