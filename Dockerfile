# Простий runtime-образ для Spring Boot під Java 17
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Можеш змінити ім'я jar за потреби
ARG JAR_FILE=target/dekanat-main-window-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

# Трошки обмежимо пам'ять під Raspberry Pi 3
ENV JAVA_OPTS="-Xms256m -Xmx768m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
