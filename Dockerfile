# ===== СТАДІЯ 1: ЗБІРКА (Maven + JDK 17) =====
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /build

# Спочатку копіюємо тільки pom.xml, щоб закешувати залежності
COPY pom.xml .

RUN mvn -B dependency:resolve dependency:resolve-plugins

# Тепер копіюємо вихідний код
COPY src ./src

# Збираємо jar
RUN mvn -B package -DskipTests


# ===== СТАДІЯ 2: РАНТАЙМ (JRE 17) =====
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Копіюємо зібраний jar із попереднього шару
COPY --from=build /build/target/*.jar app.jar

# Оптимальні налаштування під Raspberry Pi 3
ENV JAVA_OPTS="-Xms256m -Xmx768m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
