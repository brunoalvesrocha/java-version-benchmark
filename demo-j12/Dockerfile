FROM openjdk:12

ADD target/demo-0.0.1-SNAPSHOT.jar /opt/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom -Xms 1024 -Xmx 1024 -server", "-jar", "/opt/app.jar"]