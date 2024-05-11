FROM openjdk:17

WORKDIR /app

COPY target/soat3-ms-produtos-0.0.1-SNAPSHOT.jar /app/soat3-ms-produtos.jar

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "soat3-ms-produtos.jar" ]