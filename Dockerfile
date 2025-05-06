FROM openjdk:24-slim
LABEL authors="Niewczas, Kałuża"

WORKDIR /SpringData

COPY target/ZTI_SpringData-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]