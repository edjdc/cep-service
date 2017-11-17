FROM java:8

VOLUME /tmp
ADD cepservice.jar cepservice.jar
RUN sh -c 'touch /cepservice.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cepservice.jar"]