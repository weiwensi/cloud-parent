FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Enhinck
RUN apk add tzdata && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone \
    && apk del tzdata
COPY target/cloud-store-1.0-SNAPSHOT.jar.jar cloud-store.jar
ENTRYPOINT ["java","-jar","cloud-store.jar"]

EXPOSE 8761