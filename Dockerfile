# Imagen base con JDK y Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Compilar el proyecto (crea el .jar en target/)
RUN mvn clean package -DskipTests

# Etapa final
FROM eclipse-temurin:17
WORKDIR /app

# Copiar el .jar compilado
COPY --from=build /app/target/*.jar app.jar

# Puerto en el que corre Spring Boot
EXPOSE 8080

# Comando para correr la app
CMD ["java", "-jar", "app.jar"]
