FROM java:8-jre

ADD ./target/spring-es-sample-application.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/spring-es-sample-application.jar"]

EXPOSE 8080