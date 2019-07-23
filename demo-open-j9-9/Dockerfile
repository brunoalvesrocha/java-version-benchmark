FROM adoptopenjdk/openjdk9-openj9

RUN mkdir /opt/shareclasses
RUN mkdir /opt/app

ADD target/demo-0.0.1-SNAPSHOT.jar /opt/app.jar

EXPOSE 8080

CMD ["java", "-XX:MaxDirectMemorySize=1024M", "-Xquickstart" ,"-Xmx512m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-Xscmx512m", "-Xscmaxaot100m", "-Xshareclasses:cacheDir=/opt/shareclasses", "-jar", "/opt/app.jar"]
