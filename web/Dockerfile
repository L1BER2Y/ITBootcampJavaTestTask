FROM eclipse-temurin:19-jre-focal
MAINTAINER ITAcademy

ADD ./target/web.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/web.jar"]

EXPOSE 8080 8089