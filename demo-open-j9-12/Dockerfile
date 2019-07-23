FROM adoptopenjdk/openjdk12-openj9

RUN mkdir /opt/shareclasses
RUN mkdir /opt/app

ADD target/demo-0.0.1-SNAPSHOT.jar /opt/app.jar

EXPOSE 8080

CMD ["java", "-Xquickstart", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-Xshareclasses:cacheDir=/opt/shareclasses", "-jar", "/opt/app.jar"]
