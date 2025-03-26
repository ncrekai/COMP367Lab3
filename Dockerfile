FROM anapsix/alpine-java
LABEL maintainer="nrekai@my.centennialcollege.ca"
COPY ./target/comp367lab3-0.0.1-SNAPSHOT.jar /home/comp367lab3-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/comp367lab3-0.0.1-SNAPSHOT.jar"]