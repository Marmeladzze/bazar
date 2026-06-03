FROM eclipse-temurin:21-jdk-jammy as build

WORKDIR /build

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests && rm -f target/*-plain.jar

FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
CMD ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
